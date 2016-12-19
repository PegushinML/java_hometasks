package Generics_task;

import java.util.Map;

public interface CountMap<E> {
    // ��������� ������� � ���� ���������.
    void add(E e);

    //���������� ���������� ���������� ������� ��������
    int getCount(E e);

    //������� ������� � ���������� � ���������� ���������� ��� ����������(�� ��������)
    int remove(E e);

    //���������� ������ ���������
    int size();

    //�������� ��� �������� �� source � ������� ���������, ��� ���������� ������,     ����������� ��������
    void addAll(CountMap<E> source);

    //������� java.util.Map. ���� - ����������� �������, �������� - ���������� ��� ����������
    Map toMap();

    //��� �� ����� �������� ��� � toMap(), ������ ��� ���������� �������� � destination
    void toMap(Map destination);
}
