import { Campaign } from './Campaign';


export class DungeonMaster {
  id: number;
  email: string;
  firstName: string;
  lastName: string;

  currentCampaign: Campaign;
  campaigns: Campaign[];
}
