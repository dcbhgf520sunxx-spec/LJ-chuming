import { ref as y } from "vue";
import { computed as C } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as X } from "vue";
import { createVNode as v } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as o } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as u } from "vue";
import { withModifiers as _ } from "vue";
import { createTextVNode as g } from "vue";
import { resolveDynamicComponent as j } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { ElTag as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { c as te, a as P, b as I, e as ae, d as oe } from "../../../modules/visa-settle-manage-6a11f3ac.js";
import { P as m } from "../../../modules/project-19a12d6b.js";
import { t as se, kF as f, kD as S, x as ie, o as ne, iF as $, G as F, P as le } from "../../../shared/runtime.js";
import re from "./module/header.vue.js";
import ue from "./visa/form.vue.js";
import ce from "./visa/detail.vue.js";
import me from "./settlement/form.vue.js";
import pe from "./settlement/detail.vue.js";
import "../../../modules/visa-manage-fd5a2300.js";
import "../../../modules/project-visa-select-e1b3658e.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
const de = { class: "app-container" }, fe = { style: { "margin-left": "14px" } }, ve = ["onClick"], _e = ["onClick"], xe = { __name: "index", setup(he) {
  const { decimalPrecision: L } = se(), U = { add: false, edit: false, del: false, download: false }, A = y(), c = y(f.VISA.V), D = y(), x = y("detail"), z = C(() => c.value === f.VISA.V ? ue : me), B = C(() => c.value === f.VISA.V ? ce : pe), M = C(() => [["project", ["parse-project", { onlyShortName: true }]], ["status", ["parse-enum", S, { f: "SL" }]], ["amount", ["to-thousand", L.value.project]], ["createTime", "parse-time"]]), { crud: r, columns: p } = ie({ title: "签证结算", sort: ["auditTime.desc"], permission: { ...m }, invisibleColumns: [], crudApi: { ...te }, optShow: { ...U } }, D), { maxHeight: G } = ne({ paginate: true });
  function h(i, n) {
    var s;
    F(m.detail) && (x.value = n, c.value = i.type, A.value = (s = i == null ? void 0 : i.sourceRow) == null ? void 0 : s.status, r.crudApi.add = c.value === f.VISA.V ? P : I, r.toDetail(i));
  }
  function H(i) {
    c.value = i, r.crudApi.add = c.value === f.VISA.V ? P : I, r.toAdd();
  }
  function q(i) {
    c.value = i.type, r.crudApi.edit = c.value === f.VISA.V ? ae : oe, r.toEdit(i.sourceRow);
  }
  return (i, n) => {
    const s = Y, Q = E("table-cell-tag"), W = Z, V = E("common-button"), J = E("common-table"), T = O("permission"), K = ee;
    return a(), X("div", de, [v(e(re), { onToAdd: H }), k((a(), o(J, { ref_key: "tableRef", ref: D, "data-format": M.value, data: e(r).data, style: { width: "100%" }, "max-height": e(G) }, { default: l(() => [v(s, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("project") ? (a(), o(s, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: l(({ row: t }) => [v(Q, { show: t.isSubmitSettle === e($).SETTLED.V && t.type === e(f).SETTLEMENT.V, name: e($).SETTLED.L, color: "#f56c6c" }, null, 8, ["show", "name"]), N("span", fe, b(t.project), 1)]), _: 1 })) : u("", true), e(p).visible("reasonName") ? (a(), o(s, { key: "reasonName", prop: "reasonName", "show-overflow-tooltip": true, align: "center", label: "属性", "min-width": "110" }, { default: l(({ row: t }) => [N("span", { onClick: _((d) => h(t), ["stop"]), style: { cursor: "pointer" } }, b(t.reasonName), 9, ve)]), _: 1 })) : u("", true), e(p).visible("amount") ? (a(), o(s, { prop: "amount", key: "amount", label: "签证(结算)额", align: "center", "min-width": "120", "show-overflow-tooltip": "" }, { default: l(({ row: t }) => [N("span", { onClick: _((d) => h(t), ["stop"]), style: { cursor: "pointer" } }, b(t.amount), 9, _e)]), _: 1 })) : u("", true), e(p).visible("createTime") ? (a(), o(s, { key: "createTime", prop: "createTime", label: "申请日期", align: "center", "min-width": "120" })) : u("", true), e(p).visible("userName") ? (a(), o(s, { key: "userName", prop: "userName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "110" })) : u("", true), e(p).visible("checkUserName") ? (a(), o(s, { key: "checkUserName", prop: "checkUserName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "110" })) : u("", true), e(p).visible("status") ? (a(), o(s, { key: "status", prop: "status", "show-overflow-tooltip": true, align: "center", label: "状态", "min-width": "110" }, { default: l(({ row: t }) => {
      var d;
      return [v(W, { type: e(S).V[(d = t == null ? void 0 : t.sourceRow) == null ? void 0 : d.status].TAG, size: "large", effect: "plain" }, { default: l(() => [g(b(t.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : u("", true), e(F)([...e(m).detail, ...e(m).edit, ...e(m).audit]) ? (a(), o(s, { key: 7, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: l(({ row: t }) => {
      var d, w;
      return [((d = t == null ? void 0 : t.sourceRow) == null ? void 0 : d.status) === e(S).PASS.V ? k((a(), o(V, { key: 0, type: "primary", size: "default", onClick: _((R) => h(t, "detail"), ["stop"]) }, { default: l(() => n[1] || (n[1] = [g("查看")])), _: 2, __: [1] }, 1032, ["onClick"])), [[T, e(m).detail]]) : k((a(), o(V, { key: 1, type: "primary", size: "default", onClick: _((R) => q(t), ["stop"]) }, { default: l(() => n[2] || (n[2] = [g("编辑")])), _: 2, __: [2] }, 1032, ["onClick"])), [[T, e(m).edit]]), ((w = t == null ? void 0 : t.sourceRow) == null ? void 0 : w.status) === e(S).UNREVIEWED.V ? k((a(), o(V, { key: 2, type: "success", size: "default", onClick: _((R) => h(t, "audit"), ["stop"]) }, { default: l(() => n[3] || (n[3] = [g("确签")])), _: 2, __: [3] }, 1032, ["onClick"])), [[T, e(m).audit]]) : u("", true)];
    }), _: 1 })) : u("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[K, e(r).loading]]), v(e(le)), (a(), o(j(z.value))), (a(), o(j(B.value), { status: A.value, onSuccess: n[0] || (n[0] = (t) => e(r).toQuery()), showType: x.value }, null, 40, ["status", "showType"]))]);
  };
} };
export {
  xe as default
};
