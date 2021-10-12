package ru.serialization.views;

public interface View {
    interface Public {}
    interface Private {}
    interface PublicWithPartOfPrivate extends Public {}
}
