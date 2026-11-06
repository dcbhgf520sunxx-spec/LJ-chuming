import a from "./materials.vue.js";
import t from "./materials-year.vue.js";
import { openBlock as o } from "vue";
import { createBlock as e } from "vue";
import "../../../../../../shared/runtime.js";
import "../../../../../crm/crm-office/components/UploadList.vue.js";
import "../../../../../../modules/index-f80f68af.js";
import "../../../../../../modules/use-users-4d979987.js";
const M = { __name: "index", props: { purchaseInfo: { type: Object }, projectManagerOptions: { type: Array } }, setup(p) {
  const r = p;
  return (n, s) => r.purchaseInfo.boolAnnual ? (o(), e(t, { key: 1, purchaseInfo: r.purchaseInfo, projectManagerOptions: r.projectManagerOptions }, null, 8, ["purchaseInfo", "projectManagerOptions"])) : (o(), e(a, { key: 0, purchaseInfo: r.purchaseInfo, projectManagerOptions: r.projectManagerOptions }, null, 8, ["purchaseInfo", "projectManagerOptions"]));
} };
export {
  M as default
};
