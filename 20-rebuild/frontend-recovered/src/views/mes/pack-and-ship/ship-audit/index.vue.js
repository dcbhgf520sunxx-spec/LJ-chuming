import { ref as P } from "vue";
import { reactive as I } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as b } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as f } from "vue";
import { Fragment as E } from "vue";
import { renderList as q } from "vue";
import { withModifiers as R } from "vue";
import { ElNotification as Q } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElTag as J } from "element-plus";
import { vLoading as W } from "element-plus";
import { l as A, x as X, ok as d, o as Y, z as Z, bQ as v, bR as ee, aN as te, bv as ae, bi as L, G as x, L as B, P as oe } from "../../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import le from "./module/detail/index.vue.js";
import "./module/detail/module/structure.vue.js";
import "./module/detail/module/part.vue.js";
import "./module/detail/module/auxiliary-material.vue.js";
function se(p) {
  return A({ module: "mes", url: "cargo/review", method: "get", params: p });
}
function re(p) {
  return A({ module: "mes", url: `cargo/review/${p}`, method: "get" });
}
function ne({ id: p, status: y }) {
  return A({ module: "mes", url: "cargo/review", method: "put", data: { id: p, status: y } });
}
function ue({ id: p }) {
  return A({ module: "mes", url: `cargo/review/${p}/download`, method: "get", responseType: "blob" });
}
const de = { get: se, download: ue };
const pe = { class: "app-container" }, ce = { class: "project-name" }, me = { style: { "white-space": "pre-line" } }, fe = { style: { "white-space": "pre-line" } }, ke = { __name: "index", setup(p) {
  const y = { PASS: { L: "同意", K: "PASS", V: 2 }, NO_PASS: { L: "不同意", K: "NO_PASS", V: 4 } }, H = { add: false, edit: false, del: false, download: false }, T = P(), { crud: w, columns: n } = X({ title: "发运审核", sort: ["auditTime.desc"], permission: { ...d }, crudApi: { ...de }, optShow: { ...H } }, T), { maxHeight: K } = Y({ paginate: true }), k = P(false), _ = P({}), N = I({ passLoading: false, noPassLoading: false });
  function M(h) {
    _.value = h, k.value = true;
  }
  async function U(h, o) {
    try {
      N[o] = true, await ne({ id: _.value.id, status: h.V }), Q({ title: "审核成功", message: `${h.L}发运`, type: "success", duration: 2500 }), k.value = false, w.toQuery();
    } catch (r) {
      console.log("发运审核失败", r);
    } finally {
      N[o] = false;
    }
  }
  return (h, o) => {
    const r = G, V = J, S = j("common-button"), F = j("common-table"), D = z("parse-time"), $ = z("permission"), O = W;
    return a(), C("div", pe, [c(e(ie)), b((a(), l(F, { ref_key: "tableRef", ref: T, data: e(w).data, style: { width: "100%" }, "max-height": e(K), onSortChange: e(w).handleSortChange }, { default: i(() => [c(r, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("project.shortName") && !e(w).query.projectId ? (a(), l(r, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: i((t) => [u("span", ce, m(e(Z)(t.row.project)), 1)]), _: 1 })) : s("", true), e(n).visible("licensePlate") ? (a(), l(r, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" })) : s("", true), e(n).visible("serialNumber") ? (a(), l(r, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: i((t) => [c(V, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: i(() => [f(m(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : s("", true), e(n).visible("checkStatus") ? (a(), l(r, { key: "checkStatus", prop: "checkStatus", label: "审核状态", align: "center", width: "100px" }, { default: i((t) => [t.row.checkStatus ? (a(), l(V, { key: 0, type: e(v).V[t.row.checkStatus].T, effect: "plain" }, { default: i(() => [f(m(e(v).VL[t.row.checkStatus]), 1)]), _: 2 }, 1032, ["type"])) : s("", true)]), _: 1 })) : s("", true), e(n).visible("userName") ? (a(), l(r, { key: "userName", prop: "userName", sortable: "custom", "show-overflow-tooltip": true, label: "装车人", align: "center", width: "140" }, { default: i((t) => [u("span", me, [u("span", null, m(t.row.userName + `
`), 1), b(u("span", null, null, 512), [[D, t.row.loadingTime]])])]), _: 1 })) : s("", true), e(n).visible("actualUserName") ? (a(), l(r, { key: "actualUserName", prop: "actualUserName", sortable: "custom", "show-overflow-tooltip": true, label: "过磅人", align: "center", width: "140" }, { default: i((t) => [u("span", fe, [u("span", null, m(t.row.actualUserName + `
`), 1), b(u("span", null, null, 512), [[D, t.row.actualTime]])])]), _: 1 })) : s("", true), e(n).visible("auditUserName") ? (a(), l(r, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "审核人", align: "center", width: "140" })) : s("", true), e(n).visible("structureMeasureMode") ? (a(), l(r, { key: 7, "show-overflow-tooltip": true, prop: "structureMeasureMode", label: "计量方式", align: "center", "min-width": "120" }, { default: i((t) => [u("span", null, m(e(ee).VL[t.row.structureMeasureMode]), 1)]), _: 1 })) : s("", true), e(n).visible("productType") ? (a(), l(r, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: i((t) => [(a(true), C(E, null, q(e(te)(e(ae).getBits(e(L), t.row.productType, "V")), (g) => (a(), l(V, { style: { "margin-right": "5px" }, key: g, type: e(L).V[g].T, effect: "light", "disable-transitions": "" }, { default: i(() => [f(m(e(L).VL[g]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : s("", true), e(n).visible("shipAmount") ? (a(), l(r, { key: 9, "show-overflow-tooltip": true, prop: "shipAmount", label: "货物价值(元)", align: "center", "min-width": "120" }, { default: i((t) => [u("span", null, m(t.row.shipAmount), 1)]), _: 1 })) : s("", true), e(x)([...e(d).detail, ...e(d).audit, ...e(d).download]) ? (a(), l(r, { key: 10, label: "操作", width: "130px", align: "center" }, { default: i((t) => [t.row.checkStatus === e(v).CHECKED.V && e(x)(e(d).detail) ? (a(), l(S, { key: 0, type: "info", size: "default", onClick: R((g) => M(t.row), ["stop"]) }, { default: i(() => o[3] || (o[3] = [f(" 查看 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : s("", true), t.row.checkStatus === e(v).UNCHECKED.V && e(x)(e(d).audit) ? (a(), l(S, { key: 1, type: "primary", size: "default", onClick: R((g) => M(t.row), ["stop"]) }, { default: i(() => o[4] || (o[4] = [f(" 审核 ")])), _: 2, __: [4] }, 1032, ["onClick"])) : s("", true), b(c(B, { params: { id: t.row.id }, size: "default", fn: e(w).crudApi.download }, null, 8, ["params", "fn"]), [[$, e(d).download]])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange"])), [[O, e(w).loading]]), c(e(oe)), c(le, { visible: k.value, "onUpdate:visible": o[2] || (o[2] = (t) => k.value = t), "detail-info": _.value, title: "发运审核", detailFunc: e(re) }, { titleRight: i(() => [_.value.checkStatus === e(v).UNCHECKED.V ? (a(), C(E, { key: 0 }, [e(x)([...e(d).audit]) ? (a(), C(E, { key: 0 }, [c(S, { type: "primary", loading: N.passLoading, size: "default", onClick: o[0] || (o[0] = (t) => U(y.PASS, "passLoading")) }, { default: i(() => o[5] || (o[5] = [f(" 同意发运 ")])), _: 1, __: [5] }, 8, ["loading"]), c(S, { type: "danger", loading: N.noPassLoading, size: "default", onClick: o[1] || (o[1] = (t) => U(y.NO_PASS, "noPassLoading")) }, { default: i(() => o[6] || (o[6] = [f(" 不同意发运 ")])), _: 1, __: [6] }, 8, ["loading"])], 64)) : s("", true)], 64)) : b((a(), l(B, { key: 1, params: { id: _.value.id }, size: "default", fn: e(w).crudApi.download }, { default: i(() => o[7] || (o[7] = [f(" 下载发运详情 ")])), _: 1, __: [7] }, 8, ["params", "fn"])), [[$, e(d).download]])]), _: 1 }, 8, ["visible", "detail-info", "detailFunc"])]);
  };
} };
export {
  ke as default
};
