package com.homework3.common;

import com.homework3.being.CartoonCharacter;
import com.homework3.being.Evil;
import com.homework3.factory.IFactory;
import com.homework3.formation.*;

import java.util.*;

/**
 * @Description 创建随机阵型
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CreateRandomFormationArray {

    static public <T extends CartoonCharacter> List<Formation> createRandomFormationArray(IFactory<T> factory) {
        ArrayList<Formation> formationArray = new ArrayList<>();
        formationArray.add(new HeYi<>(factory.create()));
        formationArray.add(new YanXing<>(factory.create()));
        formationArray.add(new ChongE<>(factory.create()));
        formationArray.add(new ChangShe<>(factory.create()));
        formationArray.add(new YuLin<>(factory.create()));
        formationArray.add(new FangYuan<>(factory.create()));
        formationArray.add(new YanYue<>(factory.create()));
        formationArray.add(new FengShi<>(factory.create()));
        Collections.shuffle(formationArray);
        return formationArray;
    }
}
