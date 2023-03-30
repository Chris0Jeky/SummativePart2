package task2;

import java.util.*;

abstract class Member {
    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class AdultMember extends Member {
    public AdultMember(String name) {
        super(name);
    }
}

class JuniorMember extends Member {
    public JuniorMember(String name) {
        super(name);
    }
}
