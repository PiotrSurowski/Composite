package pl.piotrsurowski.structure.compositeblock.impl;

import pl.piotrsurowski.structure.block.Block;
import pl.piotrsurowski.structure.compositeblock.CompositeBlock;

import java.util.List;

public class ConcreteBeam implements CompositeBlock {
    List<Block> blocks;

    public ConcreteBeam(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String getColor() {
        return "Dark grey";
    }

    @Override
    public String getMaterial() {
        return "Concrete";
    }
}
