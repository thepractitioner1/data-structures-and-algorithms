package com.company.misan;

public class AVLTrees {
    private AVLNode root;

    public void insert(int value){
        root = insert(value, root);
    }

    public int height (){
        return height(root);
    }


    private int height(AVLNode root){
        if(root == null) return -1;
        if( root.rightChild == null && root.leftChild == null) return 0;
        return Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private AVLNode insert(int value, AVLNode root){
        if (root == null){
            return new AVLNode(value);
        }
        if(value < root.value) root.leftChild =  insert(value, root.leftChild);
        else root.rightChild = insert(value, root.rightChild);
        balance(root);
        root.height = height(root);
        return root;
    }

    private void balance(AVLNode root){
        if (isLeftHeavy(root)) {
            if(balanceFactor(root.leftChild ) < 0) System.out.println("Left Rotate " + root.leftChild.value);
            System.out.println("Right rotate" + root.value);
        }
        else if(isRightHeavy(root)){
            if (balanceFactor(root.rightChild )> 0) System.out.println("Right rotate " + root.rightChild.value);

            System.out.println("Left Rotate " + root.value);
        }
    }



    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }




    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild) ;
    }

    private class AVLNode{
        int value;
        int height;
        AVLNode leftChild;
        AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
