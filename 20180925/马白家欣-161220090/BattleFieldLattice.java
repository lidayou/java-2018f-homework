package com.homework3;

//战场格子
public class BattleFieldLattice {
    private CartoonCharacter cartoonCharacter;
    private Position position;

    public BattleFieldLattice(Position position)
    {
        this.position = position;
        cartoonCharacter = new CartoonCharacter();
    }

    public BattleFieldLattice(Position position, CartoonCharacterInfo cartoonCharacterInfo)
    {
        this.position = position;
        cartoonCharacter = new CartoonCharacter(cartoonCharacterInfo);
    }

    public CartoonCharacter getCartoonCharacter() {
        return cartoonCharacter;
    }
}

