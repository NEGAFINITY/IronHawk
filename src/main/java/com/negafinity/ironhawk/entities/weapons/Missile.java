package com.negafinity.ironhawk.entities.weapons;

import com.negafinity.ironhawk.Controller;
import com.negafinity.ironhawk.IronHawk;
import com.negafinity.ironhawk.Physics;
import com.negafinity.ironhawk.Textures;
import com.negafinity.ironhawk.entities.Enemy;
import com.negafinity.ironhawk.entities.Entity;
import com.negafinity.ironhawk.libs.Animation;

public class Missile extends Weapon
{
	public Missile(double x, double y, Textures tex, Controller c, IronHawk game, Entity firer)
	{
		super(x, y, tex, c, game, firer);

		this.name = "Missile";
		this.speed = 20;
		anim = new Animation(5, tex.missile[0], tex.missile[1]);
	}

	@Override
	public void tick()
	{
		super.tick();

		for (int i = 0; i < c.getEntities().size(); i++)
		{
			Entity entity = c.getEntities().get(i);

			if (entity instanceof Enemy)
			{
				if (Physics.collision(this, entity))
				{
					Enemy enemy = (Enemy) entity;
					enemy.enemyHealth = enemy.enemyHealth - 100;
					c.removeEntity(this);

				}
			}
		}
	}
}
