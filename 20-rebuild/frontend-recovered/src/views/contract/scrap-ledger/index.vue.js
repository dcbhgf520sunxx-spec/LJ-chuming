import d from "./module/header.vue.js";
import v from "./module/date-query.vue.js";
import y from "./module/buy-query.vue.js";
import { ref as r } from "vue";
import u from "moment";
import { openBlock as s } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as _ } from "vue";
import { createBlock as c } from "vue";
import "../../../modules/scrap-ledger-452ee452.js";
import "../../../shared/runtime.js";
import "../../../modules/contract-9b18cc88.js";
import "./contract/scrap-contract.vue.js";
import "./contract/add-contract.vue.js";
import "./module/collection-and-invoice/index.vue.js";
import "./module/collection-and-invoice/collection/index.vue.js";
import "./module/collection-and-invoice/collection/form.vue.js";
import "./module/collection-and-invoice/invoice/index.vue.js";
import "./module/collection-and-invoice/invoice/form.vue.js";
import "./module/total-amount.vue.js";
const D = { class: "app-container" }, V = { __name: "index", setup(h) {
  const a = r(1), t = r(void 0), o = r(u().startOf("month").valueOf()), n = r(u().valueOf()), l = (e) => {
    a.value = e, t.value = void 0;
  };
  function i(e, p) {
    o.value = e, n.value = p;
  }
  const m = (e) => {
    t.value = e;
  };
  return (e, p) => (s(), f("div", D, [_(d, { onWayChange: l, onDateChange: i, onTypeChange: m }), a.value === 1 ? (s(), c(y, { key: 0, queryId: a.value, startDate: o.value, endDate: n.value, scrapType: t.value }, null, 8, ["queryId", "startDate", "endDate", "scrapType"])) : (s(), c(v, { key: 1, queryId: a.value, startDate: o.value, endDate: n.value, scrapType: t.value }, null, 8, ["queryId", "startDate", "endDate", "scrapType"]))]));
} };
export {
  V as default
};
