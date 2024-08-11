package pl.piotrsurowski;

import pl.piotrsurowski.structure.Structure;
import pl.piotrsurowski.structure.block.Block;
import pl.piotrsurowski.structure.compositeblock.CompositeBlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> blocks){
        this.blocks = new ArrayList<>(blocks);
    }
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return this.getAllBlocks(blocks)
                .stream()
                .filter(block -> block.getColor().equalsIgnoreCase(color))
                .findAny();
    }

    @Override
    public List<Block> findBlockByMaterial(String material) {
        return this.getAllBlocks(blocks)
                .stream().filter(block -> block.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return this.getAllBlocks(blocks).size();
    }

    private List<Block> getAllBlocks(List<Block> blocksIn){
        return blocksIn
                .stream()
                .flatMap(block -> block instanceof CompositeBlock ? ((CompositeBlock) block).getBlocks().stream() : Stream.of(block))
                .collect(Collectors.toList());
    }
}
