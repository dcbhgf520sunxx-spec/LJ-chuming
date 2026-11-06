import { ref as m } from "vue";
import { computed as P } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as a } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as D, _ as B } from "./module/detail.vue.js";
import { t as E, bN as N, x as V, o as $, G as H, P as M } from "../../../../shared/runtime.js";
import { R as u } from "../../../../modules/contract-9b18cc88.js";
import U from "./module/header.vue.js";
const j = { class: "app-container" }, K = { __name: "index", setup(z) {
  const { decimalPrecision: p } = E(), w = { add: false, edit: false, del: false, download: false }, d = m(), g = P(() => [["businessType", ["parse-enum", N]], ["totalContractAmount", ["to-thousand", p.value.contract]], ["totalSettlementAmount", ["to-thousand", p.value.contract]]]), { crud: l, columns: i } = V({ title: "客户交易记录", sort: [], permission: { ...u }, crudApi: { ...D }, optShow: { ...w } }, d), { maxHeight: y } = $({ paginate: true }), r = m(false), f = m({});
  function k(b) {
    f.value = Object.assign({ ...l.query }, b.sourceRow), r.value = true;
  }
  return (b, h) => {
    const o = T, x = v("common-button"), C = v("common-table"), A = q;
    return e(), R("div", j, [s(t(U)), S((e(), a(C, { ref_key: "tableRef", ref: d, "data-format": g.value, data: t(l).data, style: { width: "100%" }, "max-height": t(y) }, { default: _(() => [s(o, { label: "序号", type: "index", align: "center", width: "60" }), t(i).visible("name") ? (e(), a(o, { key: "name", prop: "name", align: "left", label: "客户名称", "min-width": "160", "show-overflow-tooltip": "" })) : n("", true), t(i).visible("businessType") ? (e(), a(o, { key: "businessType", prop: "businessType", label: "订单类型", align: "center", "min-width": "100", "show-overflow-tooltip": true })) : n("", true), t(i).visible("quantity") ? (e(), a(o, { key: "quantity", prop: "quantity", label: "订单数量", align: "center", "min-width": "100", "show-overflow-tooltip": "" })) : n("", true), t(i).visible("totalContractAmount") ? (e(), a(o, { prop: "totalContractAmount", key: "totalContractAmount", label: "累计合同额", align: "center", "min-width": "120", "show-overflow-tooltip": "" })) : n("", true), t(i).visible("totalSettlementAmount") ? (e(), a(o, { prop: "totalSettlementAmount", key: "totalSettlementAmount", label: "累计结算额", align: "center", "min-width": "120", "show-overflow-tooltip": "" })) : n("", true), t(H)(t(u).detail) ? (e(), a(o, { key: 5, label: "操作", width: "80px", align: "center", fixed: "right" }, { default: _(({ row: c }) => [s(x, { size: "default", type: "info", icon: "el-icon-view", onClick: (F) => k(c) }, null, 8, ["onClick"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[A, t(l).loading]]), s(t(M)), s(t(B), { visible: r.value, "onUpdate:visible": h[0] || (h[0] = (c) => r.value = c), info: f.value, permission: t(u) }, null, 8, ["visible", "info", "permission"])]);
  };
} };
export {
  K as default
};
