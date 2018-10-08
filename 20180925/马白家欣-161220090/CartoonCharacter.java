package com.homework3;

public class CartoonCharacter {
    private CartoonCharacterInfo cartoonCharacterInfo;

    public CartoonCharacter() {
        this.cartoonCharacterInfo = CartoonCharacterInfo.VOID;
    }

    public CartoonCharacter(CartoonCharacterInfo cartoonCharacterInfo) {
        this.cartoonCharacterInfo = cartoonCharacterInfo;
    }

    public String toString() {
        return cartoonCharacterInfo.toString();
    }
}
