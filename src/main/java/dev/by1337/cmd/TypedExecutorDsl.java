package dev.by1337.cmd;

public interface TypedExecutorDsl<C> {

    Command<C> self();

    default Command<C> executor(Function1<C> runner) {
        return self().executor((c, map) -> runner.apply(c));
    }

    @SuppressWarnings("unchecked")
    default <A1> Command<C> executor(
            Argument<C, A1> a1,
            Function2<C, A1> runner
    ) {
        self().argument(a1);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2,
            Function3<C, A1, A2> runner
    ) {
        self().argument(a1);
        self().argument(a2);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3,
            Function4<C, A1, A2, A3> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4,
            Function5<C, A1, A2, A3, A4> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5,
            Function6<C, A1, A2, A3, A4, A5> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6,
            Function7<C, A1, A2, A3, A4, A5, A6> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7,
            Function8<C, A1, A2, A3, A4, A5, A6, A7> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8,
            Function9<C, A1, A2, A3, A4, A5, A6, A7, A8> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9,
            Function10<C, A1, A2, A3, A4, A5, A6, A7, A8, A9> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10,
            Function11<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11,
            Function12<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12,
            Function13<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13,
            Function14<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13, Argument<C, A14> a14,
            Function15<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);
        self().argument(a14);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name),
                (A14) map.get(a14.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13, Argument<C, A14> a14, Argument<C, A15> a15,
            Function16<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);
        self().argument(a14);
        self().argument(a15);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name),
                (A14) map.get(a14.name),
                (A15) map.get(a15.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13, Argument<C, A14> a14, Argument<C, A15> a15, Argument<C, A16> a16,
            Function17<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);
        self().argument(a14);
        self().argument(a15);
        self().argument(a16);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name),
                (A14) map.get(a14.name),
                (A15) map.get(a15.name),
                (A16) map.get(a16.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13, Argument<C, A14> a14, Argument<C, A15> a15, Argument<C, A16> a16, Argument<C, A17> a17,
            Function18<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);
        self().argument(a14);
        self().argument(a15);
        self().argument(a16);
        self().argument(a17);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name),
                (A14) map.get(a14.name),
                (A15) map.get(a15.name),
                (A16) map.get(a16.name),
                (A17) map.get(a17.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13, Argument<C, A14> a14, Argument<C, A15> a15, Argument<C, A16> a16, Argument<C, A17> a17, Argument<C, A18> a18,
            Function19<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);
        self().argument(a14);
        self().argument(a15);
        self().argument(a16);
        self().argument(a17);
        self().argument(a18);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name),
                (A14) map.get(a14.name),
                (A15) map.get(a15.name),
                (A16) map.get(a16.name),
                (A17) map.get(a17.name),
                (A18) map.get(a18.name)
        ));
    }


    @SuppressWarnings("unchecked")
    default <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19> Command<C> executor(
            Argument<C, A1> a1, Argument<C, A2> a2, Argument<C, A3> a3, Argument<C, A4> a4, Argument<C, A5> a5, Argument<C, A6> a6, Argument<C, A7> a7, Argument<C, A8> a8, Argument<C, A9> a9, Argument<C, A10> a10, Argument<C, A11> a11, Argument<C, A12> a12, Argument<C, A13> a13, Argument<C, A14> a14, Argument<C, A15> a15, Argument<C, A16> a16, Argument<C, A17> a17, Argument<C, A18> a18, Argument<C, A19> a19,
            Function20<C, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19> runner
    ) {
        self().argument(a1);
        self().argument(a2);
        self().argument(a3);
        self().argument(a4);
        self().argument(a5);
        self().argument(a6);
        self().argument(a7);
        self().argument(a8);
        self().argument(a9);
        self().argument(a10);
        self().argument(a11);
        self().argument(a12);
        self().argument(a13);
        self().argument(a14);
        self().argument(a15);
        self().argument(a16);
        self().argument(a17);
        self().argument(a18);
        self().argument(a19);

        return self().executor((c, map) -> runner.apply(
                c,
                (A1) map.get(a1.name),
                (A2) map.get(a2.name),
                (A3) map.get(a3.name),
                (A4) map.get(a4.name),
                (A5) map.get(a5.name),
                (A6) map.get(a6.name),
                (A7) map.get(a7.name),
                (A8) map.get(a8.name),
                (A9) map.get(a9.name),
                (A10) map.get(a10.name),
                (A11) map.get(a11.name),
                (A12) map.get(a12.name),
                (A13) map.get(a13.name),
                (A14) map.get(a14.name),
                (A15) map.get(a15.name),
                (A16) map.get(a16.name),
                (A17) map.get(a17.name),
                (A18) map.get(a18.name),
                (A19) map.get(a19.name)
        ));
    }

    public interface Function1<F0> {
        void apply(F0 f0);
    }

    public interface Function2<F0, F1> {
        void apply(F0 f0, F1 f1);
    }

    public interface Function3<F0, F1, F2> {
        void apply(F0 f0, F1 f1, F2 f2);
    }

    public interface Function4<F0, F1, F2, F3> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3);
    }

    public interface Function5<F0, F1, F2, F3, F4> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4);
    }

    public interface Function6<F0, F1, F2, F3, F4, F5> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5);
    }

    public interface Function7<F0, F1, F2, F3, F4, F5, F6> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6);
    }

    public interface Function8<F0, F1, F2, F3, F4, F5, F6, F7> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7);
    }

    public interface Function9<F0, F1, F2, F3, F4, F5, F6, F7, F8> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8);
    }

    public interface Function10<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9);
    }

    public interface Function11<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10);
    }

    public interface Function12<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11);
    }

    public interface Function13<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12);
    }

    public interface Function14<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13);
    }

    public interface Function15<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13, F14 f14);
    }

    public interface Function16<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13, F14 f14, F15 f15);
    }

    public interface Function17<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13, F14 f14, F15 f15, F16 f16);
    }

    public interface Function18<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13, F14 f14, F15 f15, F16 f16, F17 f17);
    }

    public interface Function19<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13, F14 f14, F15 f15, F16 f16, F17 f17, F18 f18);
    }

    public interface Function20<F0, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19> {
        void apply(F0 f0, F1 f1, F2 f2, F3 f3, F4 f4, F5 f5, F6 f6, F7 f7, F8 f8, F9 f9, F10 f10, F11 f11, F12 f12, F13 f13, F14 f14, F15 f15, F16 f16, F17 f17, F18 f18, F19 f19);
    }
}
