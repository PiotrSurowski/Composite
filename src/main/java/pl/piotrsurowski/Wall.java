package pl.piotrsurowski;

import pl.piotrsurowski.structure.Structure;
import pl.piotrsurowski.structure.block.Block;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> blocks){
        this.blocks = new ArrayList<>(blocks);
    }
    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> result = Optional.empty();
        for (Block block : blocks){
            if (block.getColor().equalsIgnoreCase(color)){
                result = Optional.of(block);
                break;
            }
        }
        return result;
    }

    @Override
    public List<Block> findBlockByMaterial(String material) {
        List<Block> result = new LinkedList<>();
        for (Block block : blocks){
            if (block.getMaterial().equalsIgnoreCase(material)){
                result.add(block);
            }
        }
        return result;
    }

    @Override
    public int count() {
        return this.blocks.size();
    }
}
