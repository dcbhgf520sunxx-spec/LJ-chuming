import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as l } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElTag as R } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as I, d as V } from "./module/detail/index.vue.js";
import { x as E, o as H, G as S, P as T } from "../../../../shared/runtime.js";
import j from "./module/header.vue.js";
import { c as v } from "../../../../modules/cutting-457c256f.js";
const A = { class: "app-container" }, O = { class: "head-container" }, J = { __name: "index", setup(U) {
  const f = h(), m = h(false), u = h(), b = { add: false, edit: false, del: false, download: false }, { crud: p, columns: c } = E({ title: "项目报表", sort: [], permission: { ...v }, optShow: { ...b }, crudApi: { ...I }, hasPagination: true }, f), { maxHeight: x } = H({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 });
  async function k(_) {
    u.value = _.cutMachine, m.value = true, console.log("  detailObj.value ", u.value);
  }
  return (_, w) => {
    const o = P, y = R, N = g("common-button"), C = g("common-table"), B = W;
    return i(), D("div", A, [s("div", O, [n(t(j))]), M((i(), l(C, { ref_key: "tableRef", ref: f, data: t(p).data, "empty-text": t(p).emptyText, "max-height": t(x) - 50, style: { width: "100%" } }, { default: a(() => [n(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("workshopInf") ? (i(), l(o, { key: "workshopInf", align: "center", prop: "workshopInf", "show-overflow-tooltip": true, label: "车间", "min-width": "40" }, { default: a((e) => [s("span", null, d(e.row.cutMachine.workshopInf), 1)]), _: 1 })) : r("", true), t(c).visible("machineName") ? (i(), l(o, { key: "machineName", align: "center", prop: "machineName", "show-overflow-tooltip": true, label: "设备名称", "min-width": "40" }, { default: a((e) => [n(y, { style: { width: "100%" }, effect: "plain" }, { default: a(() => [s("span", null, d(e.row.cutMachine.machineName), 1)]), _: 2 }, 1024)]), _: 1 })) : r("", true), t(c).visible("finishNum") ? (i(), l(o, { key: "finishNum", align: "center", prop: "finishNum", "show-overflow-tooltip": true, label: "完成数（件）", "min-width": "40" }, { default: a((e) => [s("span", null, d(e.row.finishNum ? e.row.finishNum : 0), 1)]), _: 1 })) : r("", true), t(c).visible("finishWeight") ? (i(), l(o, { key: "finishWeight", align: "center", prop: "finishWeight", "show-overflow-tooltip": true, label: "完成量（kg）", "min-width": "40" }, { default: a((e) => [s("span", null, d(e.row.finishWeight ? e.row.finishWeight : 0), 1)]), _: 1 })) : r("", true), n(o, { fixed: "right", align: "center", label: "查看", "min-width": "80px" }, { default: a((e) => [t(S)(t(v).detail) ? (i(), l(N, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: ($) => k(e.row) }, null, 8, ["onClick"])) : r("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, t(p).loading]]), n(t(T)), n(V, { "detail-data": u.value, visible: m.value, "onUpdate:visible": w[0] || (w[0] = (e) => m.value = e) }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  J as default
};
