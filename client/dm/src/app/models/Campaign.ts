import {Entity} from './Entity';

export class Campaign {
  userId: number;
  campaignId: number;
  campaignName: string;
  activeEntities: Entity[];
  currentRound: number;
  currentTurn: number;
  status: string;
}
