import { ref as N } from "vue";
import { computed as V } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as $ } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as o } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as z } from "vue";
import { withModifiers as k } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as B } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as G } from "../../../../modules/settlement-manage-aa83dffa.js";
import { P as c } from "../../../../modules/contract-9b18cc88.js";
import { t as H, kD as v, x as L, o as q, G as I, P as Q } from "../../../../shared/runtime.js";
import W from "./module/header.vue.js";
import J from "./module/form.vue.js";
import K from "./module/detail.vue.js";
import "../../../../modules/project-visa-select-e1b3658e.js";
const O = { class: "app-container" }, ne = { __name: "index", setup(X) {
  const { decimalPrecision: b } = H(), S = { add: true, edit: false, del: false, download: false }, y = N(), C = N(), T = V(() => [["project", "parse-project"], ["status", ["parse-enum", v, { f: "SL" }]], ["contractAmount", ["to-thousand", b.value.contract]], ["amount", ["to-thousand", b.value.contract]], ["createTime", "parse-time"]]), { crud: u, columns: l } = L({ title: "结算管理", sort: ["auditTime.desc"], permission: { ...c }, invisibleColumns: [], crudApi: { ...G }, optShow: { ...S } }, C), { maxHeight: A } = q({ paginate: true });
  function x(p) {
    var i;
    y.value = (i = p == null ? void 0 : p.sourceRow) == null ? void 0 : i.status, u.toDetail(p);
  }
  return (p, i) => {
    const s = M, E = B, h = R("common-button"), P = R("common-table"), g = j("permission"), U = F;
    return a(), $("div", O, [m(e(W)), f((a(), o(P, { ref_key: "tableRef", ref: C, "data-format": T.value, data: e(u).data, style: { width: "100%" }, "max-height": e(A) }, { default: r(() => [m(s, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("project") ? (a(), o(s, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250" })) : n("", true), e(l).visible("contractAmount") ? (a(), o(s, { prop: "contractAmount", key: "contractAmount", label: "合同额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : n("", true), e(l).visible("amount") ? (a(), o(s, { prop: "amount", key: "amount", label: "结算额", align: "right", "min-width": "120", "show-overflow-tooltip": "" })) : n("", true), e(l).visible("createTime") ? (a(), o(s, { key: "createTime", prop: "createTime", label: "申请日期", align: "center", "min-width": "120" })) : n("", true), e(l).visible("createUserName") ? (a(), o(s, { key: "createUserName", prop: "createUserName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "110" })) : n("", true), e(l).visible("checkUserName") ? (a(), o(s, { key: "checkUserName", prop: "checkUserName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "110" })) : n("", true), e(l).visible("status") ? (a(), o(s, { key: "status", prop: "status", "show-overflow-tooltip": true, align: "center", label: "状态", "min-width": "110" }, { default: r(({ row: t }) => {
      var d;
      return [m(E, { type: e(v).V[(d = t == null ? void 0 : t.sourceRow) == null ? void 0 : d.status].TAG, size: "large", effect: "plain" }, { default: r(() => [_(z(t.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : n("", true), e(I)([...e(c).detail, ...e(c).edit, ...e(c).audit]) ? (a(), o(s, { key: 7, label: "操作", width: "170", fixed: "right", align: "center" }, { default: r(({ row: t }) => {
      var d, w;
      return [((d = t == null ? void 0 : t.sourceRow) == null ? void 0 : d.status) === e(v).PASS.V ? f((a(), o(h, { key: 0, type: "primary", size: "default", onClick: k((D) => x(t), ["stop"]) }, { default: r(() => i[1] || (i[1] = [_("查看")])), _: 2, __: [1] }, 1032, ["onClick"])), [[g, e(c).detail]]) : f((a(), o(h, { key: 1, type: "primary", size: "default", onClick: k((D) => e(u).toEdit(t), ["stop"]) }, { default: r(() => i[2] || (i[2] = [_("编辑")])), _: 2, __: [2] }, 1032, ["onClick"])), [[g, e(c).edit]]), ((w = t == null ? void 0 : t.sourceRow) == null ? void 0 : w.status) === e(v).UNREVIEWED.V ? f((a(), o(h, { key: 2, type: "success", size: "default", onClick: k((D) => x(t), ["stop"]) }, { default: r(() => i[3] || (i[3] = [_("确签")])), _: 2, __: [3] }, 1032, ["onClick"])), [[g, e(c).audit]]) : n("", true)];
    }), _: 1 })) : n("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[U, e(u).loading]]), m(e(Q)), m(e(J)), m(K, { status: y.value, onSuccess: i[0] || (i[0] = (t) => e(u).toQuery()) }, null, 8, ["status"])]);
  };
} };
export {
  ne as default
};
