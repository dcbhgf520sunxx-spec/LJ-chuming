import { openBlock as a } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as t } from "vue";
import { withCtx as r } from "vue";
import { createBlock as p } from "vue";
import { unref as n } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as u } from "vue";
import { Fragment as m } from "vue";
import { ElTableColumn as w } from "element-plus";
import { ElTag as h } from "element-plus";
import { pP as s } from "../../../../../../../../shared/runtime.js";
const _ = { key: 1 }, b = { __name: "shipping-table", setup(d) {
  return (g, f) => {
    const e = w, i = h;
    return a(), l(m, null, [t(e, { key: "workShopName", prop: "workShopName", "show-overflow-tooltip": true, label: "车间名称", align: "center", "min-width": "140" }), t(e, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", "min-width": "140" }), t(e, { key: "userNames", prop: "userNames", "show-overflow-tooltip": true, label: "操作人", align: "center", "min-width": "140" }), t(e, { key: "dateTimes", prop: "dateTimes", "show-overflow-tooltip": true, label: "操作时间", align: "center", "min-width": "140" }), t(e, { key: "cargoSerialNumbers", prop: "cargoSerialNumbers", "show-overflow-tooltip": true, label: "车次/船次编号", align: "center", "min-width": "140" }), t(e, { key: "licensePlate", prop: "licensePlate", "show-overflow-tooltip": true, label: "车牌/船牌", align: "center", "min-width": "140" }), t(e, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "类型", align: "center", "min-width": "140" }, { default: r(({ row: o }) => [o.status ? (a(), p(i, { key: 0, effect: "plain", size: "large", type: n(s).V[o.status].T }, { default: r(() => [c(u(n(s).VL[o.status]), 1)]), _: 2 }, 1032, ["type"])) : (a(), l("span", _, "-"))]), _: 1 })], 64);
  };
} };
export {
  b as default
};
