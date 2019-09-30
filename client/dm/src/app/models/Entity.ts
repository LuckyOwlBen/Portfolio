export class Entity {
  id: number;
  campaignId: number;
  name: string;
  entityType: string;
  hp: number;
  currentHp: number;
  armorClass: number;
  conditions: string[];
  initiativeMod: number;
  initiativeTotal: number;
}
