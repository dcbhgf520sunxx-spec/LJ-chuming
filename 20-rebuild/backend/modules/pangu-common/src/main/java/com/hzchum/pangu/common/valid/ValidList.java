package com.hzchum.pangu.common.valid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.validation.Valid;

public class ValidList<E> implements List<E> {
   @Valid
   private List<E> list = new ArrayList<>();

   @Override
   public int size() {
      return this.list.size();
   }

   @Override
   public boolean isEmpty() {
      return this.list.isEmpty();
   }

   @Override
   public boolean contains(Object o) {
      return this.list.contains(o);
   }

   @Override
   public Iterator<E> iterator() {
      return this.list.iterator();
   }

   @Override
   public Object[] toArray() {
      return this.list.toArray();
   }

   @Override
   public <T> T[] toArray(T[] a) {
      return (T[])this.list.toArray(a);
   }

   @Override
   public boolean add(E e) {
      return this.list.add(e);
   }

   @Override
   public boolean remove(Object o) {
      return this.list.remove(o);
   }

   @Override
   public boolean containsAll(Collection<?> c) {
      return this.list.contains(c);
   }

   @Override
   public boolean addAll(Collection<? extends E> c) {
      return this.list.addAll(c);
   }

   @Override
   public boolean addAll(int index, Collection<? extends E> c) {
      return this.list.addAll(index, c);
   }

   @Override
   public boolean removeAll(Collection<?> c) {
      return this.list.removeAll(c);
   }

   @Override
   public boolean retainAll(Collection<?> c) {
      return this.list.retainAll(c);
   }

   @Override
   public void clear() {
      this.list.clear();
   }

   @Override
   public E get(int index) {
      return this.list.get(index);
   }

   @Override
   public E set(int index, E element) {
      return this.list.set(index, element);
   }

   @Override
   public void add(int index, E element) {
      this.list.add(index, element);
   }

   @Override
   public E remove(int index) {
      return this.list.remove(index);
   }

   @Override
   public int indexOf(Object o) {
      return this.list.indexOf(o);
   }

   @Override
   public int lastIndexOf(Object o) {
      return this.list.lastIndexOf(o);
   }

   @Override
   public ListIterator<E> listIterator() {
      return this.list.listIterator();
   }

   @Override
   public ListIterator<E> listIterator(int index) {
      return this.list.listIterator(index);
   }

   @Override
   public List<E> subList(int fromIndex, int toIndex) {
      return this.list.subList(fromIndex, toIndex);
   }

   public List<E> getList() {
      return this.list;
   }

   public void setList(final List<E> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ValidList)) {
         return false;
      }

      ValidList<?> other = (ValidList<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$list = this.getList();
      Object other$list = other.getList();
      return this$list == null ? other$list == null : this$list.equals(other$list);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ValidList;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "ValidList(list=" + this.getList() + ")";
   }
}
