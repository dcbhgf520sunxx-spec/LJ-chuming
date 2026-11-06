import { ref as E } from "vue";
import { reactive as O } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as r } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as f } from "vue";
import { Fragment as T } from "vue";
import { renderList as q } from "vue";
import { withModifiers as R } from "vue";
import { ElNotification as Q } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElTag as J } from "element-plus";
import { vLoading as W } from "element-plus";
import { l as P, x as X, o as Y, z as Z, bQ as v, bw as x, bR as ee, aN as te, bv as ae, G as A, L as H, P as oe } from "../../../../shared/runtime.js";
import { s as u } from "../../../../modules/bridge-86f96a4f.js";
import ie from "./module/header.vue.js";
import re from "./module/detail/index.vue.js";
import "./module/detail/module/structure.vue.js";
import "./module/detail/module/enclosure.vue.js";
import "./module/detail/module/auxiliary-material.vue.js";
function se(d) {
  return P({ module: "bridge", url: "cargo/review", method: "get", params: d });
}
function le(d) {
  return P({ module: "bridge", url: `cargo/review/${d}`, method: "get" });
}
function ne({ id: d, status: k }) {
  return P({ module: "bridge", url: "cargo/review", method: "put", data: { id: d, status: k } });
}
function ue({ id: d }) {
  return P({ module: "bridge", url: `cargo/review/${d}/download`, method: "get", responseType: "blob" });
}
const de = { get: se, download: ue };
const pe = { class: "app-container" }, ce = { class: "project-name" }, me = { style: { "white-space": "pre-line" } }, fe = { style: { "white-space": "pre-line" } }, we = { key: 0 }, _e = { key: 1 }, Ce = { __name: "index", setup(d) {
  const k = { PASS: { L: "同意", K: "PASS", V: 2 }, NO_PASS: { L: "不同意", K: "NO_PASS", V: 4 } }, B = { add: false, edit: false, del: false, download: false }, L = E(), { crud: w, columns: n } = X({ title: "发运审核", sort: ["auditTime.desc"], permission: { ...u }, crudApi: { ...de }, optShow: { ...B } }, L), { maxHeight: K } = Y({ paginate: true }), N = E(false), g = E({}), S = O({ passLoading: false, noPassLoading: false });
  function M(h) {
    g.value = h, N.value = true;
  }
  async function U(h, o) {
    try {
      S[o] = true, await ne({ id: g.value.id, status: h.V }), Q({ title: "审核成功", message: `${h.L}发运`, type: "success", duration: 2500 }), N.value = false, w.toQuery();
    } catch (l) {
      console.log("发运审核失败", l);
    } finally {
      S[o] = false;
    }
  }
  return (h, o) => {
    const l = G, V = J, C = j("common-button"), F = j("common-table"), D = z("parse-time"), $ = z("permission"), I = W;
    return a(), _("div", pe, [p(e(ie)), y((a(), r(F, { ref_key: "tableRef", ref: L, data: e(w).data, style: { width: "100%" }, "max-height": e(K), onSortChange: e(w).handleSortChange }, { default: i(() => [p(l, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("project.shortName") && !e(w).query.projectId ? (a(), r(l, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: i((t) => [c("span", ce, m(e(Z)(t.row.project)), 1)]), _: 1 })) : s("", true), e(n).visible("licensePlate") ? (a(), r(l, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" })) : s("", true), e(n).visible("serialNumber") ? (a(), r(l, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: i((t) => [p(V, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: i(() => [f(m(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : s("", true), e(n).visible("checkStatus") ? (a(), r(l, { key: "checkStatus", prop: "checkStatus", label: "审核状态", align: "center", width: "100px" }, { default: i((t) => [t.row.checkStatus ? (a(), r(V, { key: 0, type: e(v).V[t.row.checkStatus].T, effect: "plain" }, { default: i(() => [f(m(e(v).VL[t.row.checkStatus]), 1)]), _: 2 }, 1032, ["type"])) : s("", true)]), _: 1 })) : s("", true), e(n).visible("userName") ? (a(), r(l, { key: "userName", prop: "userName", sortable: "custom", "show-overflow-tooltip": true, label: "装车人", align: "center", width: "140" }, { default: i((t) => [c("span", me, [c("span", null, m(t.row.userName + `
`), 1), y(c("span", null, null, 512), [[D, t.row.loadingTime]])])]), _: 1 })) : s("", true), e(n).visible("actualUserName") ? (a(), r(l, { key: "actualUserName", prop: "actualUserName", sortable: "custom", "show-overflow-tooltip": true, label: "过磅人", align: "center", width: "140" }, { default: i((t) => [c("span", fe, [c("span", null, m(t.row.actualUserName + `
`), 1), y(c("span", null, null, 512), [[D, t.row.actualTime]])])]), _: 1 })) : s("", true), e(n).visible("auditUserName") ? (a(), r(l, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "审核人", align: "center", width: "140" })) : s("", true), e(n).visible("structureMeasureMode") ? (a(), r(l, { key: 7, "show-overflow-tooltip": true, prop: "structureMeasureMode", label: "计量方式", align: "center", "min-width": "120" }, { default: i((t) => [t.row.productType !== e(x).MACHINE_PART.V ? (a(), _("span", we, m(e(ee).VL[t.row.structureMeasureMode]), 1)) : (a(), _("span", _e, "-"))]), _: 1 })) : s("", true), e(n).visible("productType") ? (a(), r(l, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: i((t) => [(a(true), _(T, null, q(e(te)(e(ae).getBits(e(x), t.row.productType, "V")), (b) => (a(), r(V, { style: { "margin-right": "5px" }, key: b, type: e(x).V[b].T, effect: "light", "disable-transitions": "" }, { default: i(() => [f(m(e(x).VL[b]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : s("", true), e(n).visible("shipAmount") ? (a(), r(l, { key: 9, "show-overflow-tooltip": true, prop: "shipAmount", label: "货物价值(元)", align: "center", "min-width": "120" }, { default: i((t) => [c("span", null, m(t.row.shipAmount), 1)]), _: 1 })) : s("", true), e(A)([...e(u).detail, ...e(u).audit, ...e(u).download]) ? (a(), r(l, { key: 10, label: "操作", width: "130px", align: "center" }, { default: i((t) => [t.row.checkStatus === e(v).CHECKED.V && e(A)(e(u).detail) ? (a(), r(C, { key: 0, type: "info", size: "default", onClick: R((b) => M(t.row), ["stop"]) }, { default: i(() => o[3] || (o[3] = [f(" 查看 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : s("", true), t.row.checkStatus === e(v).UNCHECKED.V && e(A)(e(u).audit) ? (a(), r(C, { key: 1, type: "primary", size: "default", onClick: R((b) => M(t.row), ["stop"]) }, { default: i(() => o[4] || (o[4] = [f(" 审核 ")])), _: 2, __: [4] }, 1032, ["onClick"])) : s("", true), y(p(H, { params: { id: t.row.id }, size: "default", fn: e(w).crudApi.download }, null, 8, ["params", "fn"]), [[$, e(u).download]])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange"])), [[I, e(w).loading]]), p(e(oe)), p(re, { visible: N.value, "onUpdate:visible": o[2] || (o[2] = (t) => N.value = t), "detail-info": g.value, title: "发运审核", detailFunc: e(le) }, { titleRight: i(() => [g.value.checkStatus === e(v).UNCHECKED.V ? (a(), _(T, { key: 0 }, [e(A)([...e(u).audit]) ? (a(), _(T, { key: 0 }, [p(C, { type: "primary", loading: S.passLoading, size: "default", onClick: o[0] || (o[0] = (t) => U(k.PASS, "passLoading")) }, { default: i(() => o[5] || (o[5] = [f(" 同意发运 ")])), _: 1, __: [5] }, 8, ["loading"]), p(C, { type: "danger", loading: S.noPassLoading, size: "default", onClick: o[1] || (o[1] = (t) => U(k.NO_PASS, "noPassLoading")) }, { default: i(() => o[6] || (o[6] = [f(" 不同意发运 ")])), _: 1, __: [6] }, 8, ["loading"])], 64)) : s("", true)], 64)) : y((a(), r(H, { key: 1, params: { id: g.value.id }, size: "default", fn: e(w).crudApi.download }, { default: i(() => o[7] || (o[7] = [f(" 下载发运详情 ")])), _: 1, __: [7] }, 8, ["params", "fn"])), [[$, e(u).download]])]), _: 1 }, 8, ["visible", "detail-info", "detailFunc"])]);
  };
} };
export {
  Ce as default
};
