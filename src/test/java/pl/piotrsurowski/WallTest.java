package pl.piotrsurowski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.piotrsurowski.structure.block.Block;
import pl.piotrsurowski.structure.block.impl.ConcreteBlock;
import pl.piotrsurowski.structure.block.impl.WoodenBlock;
import pl.piotrsurowski.structure.compositeblock.CompositeBlock;
import pl.piotrsurowski.structure.compositeblock.impl.ConcreteBeam;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall wall;

    @BeforeEach
    void prepareBlocks() {
        Block concreteBlock = new ConcreteBlock();
        Block woodenBlock = new WoodenBlock();
        Block metalBlock = new Block() {
            @Override
            public String getColor() {
                return "silver";
            }

            @Override
            public String getMaterial() {
                return "steel";
            }
        };

        CompositeBlock concreteBeam = new ConcreteBeam(List.of(concreteBlock, new ConcreteBlock()));
        CompositeBlock decorativeBlock = new CompositeBlock() {
            @Override
            public List<Block> getBlocks() {
                return List.of(woodenBlock, metalBlock);
            }

            @Override
            public String getColor() {
                return "Mixed";
            }

            @Override
            public String getMaterial() {
                return "Mixed";
            }
        };
        wall = new Wall(List.of(concreteBeam, decorativeBlock, new ConcreteBlock()));
    }

    @Test
    void findBlockByColor() {
        Optional<Block> block = wall.findBlockByColor("grey");
        assertTrue(block.isPresent());
        assertEquals("Grey", block.get().getColor());
    }

    @Test
    void findByColorNull(){
        Optional<Block> block = wall.findBlockByColor(null);
        assertTrue(block.isEmpty());
    }

    @Test
    void findBlockByMaterial() {
        List<Block> blocks = wall.findBlockByMaterial("concRETE");
        assertEquals(3, blocks.size());
        assertTrue(blocks.stream().allMatch(block -> "Concrete".equalsIgnoreCase(block.getMaterial())));
    }

    @Test
    void findByMaterialNull(){
        List<Block> blocks = wall.findBlockByMaterial(null);
        assertEquals(0, blocks.size());
    }

    @Test
    void count() {
        Integer count = wall.count();
        assertEquals(5, count);
    }
}