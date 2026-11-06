import { ref as S } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as B } from "vue";
import { toDisplayString as D } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as _ } from "vue";
import { withModifiers as g } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as H } from "../../../../modules/visa-manage-fd5a2300.js";
import { U as c } from "../../../../modules/contract-9b18cc88.js";
import { t as q, kD as v, x as I, o as Q, br as W, iF as E, G as J, P as K } from "../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import X from "./module/form.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../modules/project-visa-select-e1b3658e.js";
const Z = { class: "app-container" }, ee = { style: { "margin-left": "14px" } }, ce = { __name: "index", setup(te) {
  const { decimalPrecision: w } = q(), R = { add: true, edit: false, del: false, download: false }, k = S(), y = S(), U = $(() => [["project", "parse-project"], ["status", ["parse-enum", v, { f: "SL" }]], ["amount", ["to-thousand", w.value.contract]], ["createTime", "parse-time"]]), { crud: u, columns: r } = I({ title: "签证管理", sort: ["auditTime.desc"], permission: { ...c }, invisibleColumns: [], crudApi: { ...H }, optShow: { ...R } }, y), { maxHeight: V } = Q({ paginate: true });
  function T(p) {
    var o;
    k.value = (o = p == null ? void 0 : p.sourceRow) == null ? void 0 : o.status, u.toDetail(p);
  }
  return (p, o) => {
    const l = M, j = F, h = x("common-button"), P = x("common-table"), b = z("permission"), L = G;
    return a(), A("div", Z, [m(e(O)), f((a(), s(P, { ref_key: "tableRef", ref: y, "data-format": U.value, data: e(u).data, style: { width: "100%" }, "max-height": e(V) }, { default: n(() => [m(l, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("project") ? (a(), s(l, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: n(({ row: t }) => [m(W, { show: t.isSubmitSettle === e(E).SETTLED.V, name: e(E).SETTLED.L, color: "#f56c6c" }, null, 8, ["show", "name"]), B("span", ee, D(t.project), 1)]), _: 1 })) : i("", true), e(r).visible("reasonName") ? (a(), s(l, { key: "reasonName", prop: "reasonName", "show-overflow-tooltip": true, align: "center", label: "签证原因", "min-width": "110" })) : i("", true), e(r).visible("amount") ? (a(), s(l, { prop: "amount", key: "amount", label: "签证额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("createTime") ? (a(), s(l, { key: "createTime", prop: "createTime", label: "申请日期", align: "center", "min-width": "120" })) : i("", true), e(r).visible("createUserName") ? (a(), s(l, { key: "createUserName", prop: "createUserName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "110" })) : i("", true), e(r).visible("checkUserName") ? (a(), s(l, { key: "checkUserName", prop: "checkUserName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "110" })) : i("", true), e(r).visible("status") ? (a(), s(l, { key: "status", prop: "status", "show-overflow-tooltip": true, align: "center", label: "状态", "min-width": "110" }, { default: n(({ row: t }) => {
      var d;
      return [m(j, { type: e(v).V[(d = t == null ? void 0 : t.sourceRow) == null ? void 0 : d.status].TAG, size: "large", effect: "plain" }, { default: n(() => [_(D(t.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), e(J)([...e(c).detail, ...e(c).edit, ...e(c).audit]) ? (a(), s(l, { key: 7, label: "操作", width: "140", fixed: "right" }, { default: n(({ row: t }) => {
      var d, C;
      return [((d = t == null ? void 0 : t.sourceRow) == null ? void 0 : d.status) === e(v).PASS.V ? f((a(), s(h, { key: 0, type: "primary", size: "default", onClick: g((N) => T(t), ["stop"]) }, { default: n(() => o[1] || (o[1] = [_("查看")])), _: 2, __: [1] }, 1032, ["onClick"])), [[b, e(c).detail]]) : t.settlementRecord ? i("", true) : f((a(), s(h, { key: 1, type: "primary", size: "default", onClick: g((N) => e(u).toEdit(t), ["stop"]) }, { default: n(() => o[2] || (o[2] = [_("编辑")])), _: 2, __: [2] }, 1032, ["onClick"])), [[b, e(c).edit]]), ((C = t == null ? void 0 : t.sourceRow) == null ? void 0 : C.status) === e(v).UNREVIEWED.V ? f((a(), s(h, { key: 2, type: "success", size: "default", onClick: g((N) => T(t), ["stop"]) }, { default: n(() => o[3] || (o[3] = [_("确签")])), _: 2, __: [3] }, 1032, ["onClick"])), [[b, e(c).audit]]) : i("", true)];
    }), _: 1 })) : i("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[L, e(u).loading]]), m(e(K)), m(e(X)), m(Y, { status: k.value, onSuccess: o[0] || (o[0] = (t) => e(u).toQuery()) }, null, 8, ["status"])]);
  };
} };
export {
  ce as default
};
