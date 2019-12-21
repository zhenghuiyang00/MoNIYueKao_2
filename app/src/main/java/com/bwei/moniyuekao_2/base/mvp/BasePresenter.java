package com.bwei.moniyuekao_2.base.mvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    //弱引用
    public WeakReference<V> weakReference;


    public BasePresenter(){
        model=initModel();
    }
    public void attach(V v){
        weakReference=new WeakReference<>(v);
    }

    protected abstract M initModel();

    /**
     * 解绑，解决内存呢泄漏问题
     */
    public void dettach(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

    public V getView(){
        return weakReference.get();
    }


}
