package pl.piotrsurowski.structure.block.impl;

import pl.piotrsurowski.structure.block.Block;

public class ConcreteBlock implements Block {
    @Override
    public String getColor() {
        return "Grey";
    }

    @Override
    public String getMaterial() {
        return "Concrete";
    }
}
