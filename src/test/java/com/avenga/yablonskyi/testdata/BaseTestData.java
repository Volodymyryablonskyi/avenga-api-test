package com.avenga.yablonskyi.testdata;

import com.avenga.yablonskyi.pojo.BasePojo;
import com.avenga.yablonskyi.util.Randomizer;

public interface BaseTestData {

    default int getRandomId(int min, int max) {
        return Randomizer.getRandomNumberInRange(min, max);
    }

    default int getExistingId() {
        return getRandomId(1, 100);
    }

    default int getNotExistingId() {
        return getRandomId(1000, 9999);
    }

    BasePojo generateExisting();
    BasePojo generateForUpdate();
    BasePojo generateNotExisting();
    BasePojo generateInvalid();

}
