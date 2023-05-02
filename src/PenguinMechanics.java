public class PenguinMechanics {
    private boolean jumping = false;
    private boolean falling = false;
    private double velY = 0.0;
    private float gravity = 0.5f;

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void tick() {
        if (jumping)
        {
            velY -= gravity;
            System.out.println(velY);
            if (gravity <= 0.0)
            {
                jumping = false;
                falling = true;
            }
        }
    }
}
