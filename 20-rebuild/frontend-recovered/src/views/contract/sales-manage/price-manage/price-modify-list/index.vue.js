import { inject as M } from "vue";
import { ref as u } from "vue";
import { watch as j } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as o } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as B } from "vue";
import { withModifiers as H } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as q } from "element-plus";
import { d as z, e as G } from "../../../../../modules/common-913d415d.js";
import { O as f } from "../../../../../modules/contract-9b18cc88.js";
import { kD as y, x as $, o as F, kz as h, G as K, P as Q } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const J = { class: "modify-container" }, le = { __name: "index", emits: ["refresh-data"], setup(W, { emit: k }) {
  const g = k, v = M("modifyVisible"), x = { add: false, edit: false, del: false, download: false }, w = u(), _ = u({}), T = u([["project", "parse-project"], ["status", ["parse-enum", y]], ["createTime", "parse-time"], ["checkTime", "parse-time"]]), { crud: l, columns: r, CRUD: C } = $({ title: "商务价格变更记录", sort: [], permission: { ...f, get: f.list }, crudApi: { get: z, detail: G }, optShow: { ...x }, invisibleColumns: [] }, w);
  j(v, (s) => {
    s && l.toQuery();
  }, { immediate: true });
  function R() {
    l.refresh(), g("refresh-data");
  }
  const { maxHeight: N } = F({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], extraHeight: 20, paginate: true });
  C.HOOK.handleRefresh = (s) => {
    s.data = s.data.map((p, t) => (p.rowId = t + "" + Math.random(), p));
  };
  function U(s) {
    _.value = s.sourceRow, l.toDetail(s).sourceRow;
  }
  return (s, p) => {
    const t = L, E = O, D = b("common-button"), S = b("common-table"), V = q;
    return a(), P("div", J, [c(e(X)), A((a(), o(S, { ref_key: "tableRef", ref: w, "data-format": T.value, data: e(l).data, "row-key": "rowId", style: { width: "100%" }, "max-height": e(N) - 80 }, { default: m(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("project") ? (a(), o(t, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "项目", "min-width": "140" })) : i("", true), e(r).visible("monomer.name") && e(l).query.type !== e(h).AUXILIARY_MATERIAL.V && e(l).query.type !== e(h).ENCLOSURE.V ? (a(), o(t, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "min-width": "120", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("enclosurePlan.name") && e(l).query.type === e(h).ENCLOSURE.V ? (a(), o(t, { key: "enclosurePlan.name", prop: "enclosurePlan.name", label: "批次", align: "center", "min-width": "120", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("remark") ? (a(), o(t, { key: "remark", prop: "remark", label: "事由", align: "center", "min-width": "140", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("createUserName") ? (a(), o(t, { key: "createUserName", prop: "createUserName", label: "创建人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("createTime") ? (a(), o(t, { key: "createTime", prop: "createTime", label: "创建时间", align: "center", width: "130", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("checkUserName") ? (a(), o(t, { key: "checkUserName", prop: "checkUserName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("checkTime") ? (a(), o(t, { key: "checkTime", prop: "checkTime", label: "审核时间", align: "center", width: "130", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("status") ? (a(), o(t, { key: 8, prop: "status", align: "center", width: "90", label: "状态", "show-overflow-tooltip": "" }, { default: m(({ row: n }) => {
      var d;
      return [c(E, { type: e(y).V[(d = n == null ? void 0 : n.sourceRow) == null ? void 0 : d.status].TAG, size: "large", effect: "plain" }, { default: m(() => [I(B(n.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), e(K)(e(f).detail) ? (a(), o(t, { key: 9, label: "操作", width: "70px", align: "center", fixed: "right" }, { default: m(({ row: n }) => [c(D, { icon: "el-icon-view", type: "info", size: "default", onClick: H((d) => U(n), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[V, e(l).loading]]), c(e(Q)), c(e(Y), { "detail-info": _.value, onSuccess: R }, null, 8, ["detail-info"])]);
  };
} };
export {
  le as default
};
