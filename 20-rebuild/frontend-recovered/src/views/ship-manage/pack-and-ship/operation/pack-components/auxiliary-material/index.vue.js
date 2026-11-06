import { inject as N } from "vue";
import { ref as w } from "vue";
import { nextTick as H } from "vue";
import { computed as B } from "vue";
import { watch as E } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as K } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as g } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as u } from "vue";
import { ElTableColumn as V } from "element-plus";
import { vLoading as $ } from "element-plus";
import { g as L } from "../../../../../../modules/manual-pack-aab80853.js";
import { _ as z, x as G, bi as X, G as Y, P as F } from "../../../../../../shared/runtime.js";
import J from "./module/header.vue.js";
const W = { class: "app-container" }, Z = { class: "head-container" }, ee = ["onClick"], te = { key: 1 }, ae = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, manufactureType: { type: [String, Number] } }, emits: ["add", "qhseNumbers"], setup(I, { expose: q, emit: U }) {
  const v = N("permission"), P = { add: false, edit: false, del: false, download: false }, b = w(), { crud: i, columns: c, CRUD: x } = G({ title: "手工打包（辅材）", sort: [], permission: { ...v }, optShow: { ...P }, crudApi: { get: L }, invisibleColumns: ["drawingNumber", "packageQuantity", "batchAdd"], queryOnPresenterCreated: false, hasPagination: true }, b), f = X.AUXILIARY_MATERIAL.K, _ = U, l = I, C = w();
  H(() => {
    C.value = l.maxHeight;
  });
  const T = N("packData"), Q = B(() => Object.keys(T[f]));
  function A(s) {
    return !s || s.id == null ? false : !Q.value.includes(String(s.id));
  }
  E(() => [l.projectId, l.manufactureType], () => {
    i.toQuery();
  }, { immediate: true }), x.HOOK.beforeRefresh = () => {
    i.query.projectId = l.projectId, i.query.monomerId = l.monomerId, i.query.areaId = l.areaId, i.query.boolOutsourcing = !!l.manufactureType;
  };
  function R(s) {
    _("add", s, f);
  }
  function j() {
    _("batchAdd", i.selections, f), b.value.clearSelection();
  }
  return x.HOOK.handleRefresh = (s, m) => {
    var y;
    m.data.content = (y = m.data.content) == null ? void 0 : y.map((t) => (t.productQuantity = t.unPackageQuantity, t));
  }, q({ refresh: i.toQuery }), (s, m) => {
    const y = S("common-button"), t = V, D = S("common-table"), O = $;
    return a(), h("div", W, [K("div", Z, [d(e(J)), d(y, { size: "default", type: "primary", onClick: j }, { default: p(() => m[0] || (m[0] = [g(" 批量添加 ")])), _: 1, __: [0] })]), M((a(), o(D, { ref_key: "tableRef", ref: b, data: e(i).data, "empty-text": e(i).emptyText, "max-height": C.value, style: { width: "100%" }, onSortChange: e(i).handleSortChange, onSelectionChange: e(i).selectionChangeHandler }, { default: p(() => [d(t, { key: "selection", type: "selection", width: "55", align: "center", selectable: A }), d(t, { align: "center", label: "序号", type: "index", width: "60" }), e(c).visible("name") ? (a(), o(t, { key: "name", align: "center", label: "名称", prop: "name" })) : r("", true), e(c).visible("specification") ? (a(), o(t, { key: "specification", align: "center", label: "规格", prop: "specification" })) : r("", true), e(c).visible("accountingUnit") ? (a(), o(t, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit" })) : r("", true), e(c).visible("mete") ? (a(), o(t, { key: "mete", align: "center", label: "核算量", prop: "mete" })) : r("", true), e(c).visible("quantity") ? (a(), o(t, { key: "quantity", align: "center", label: "清单数", prop: "quantity", sortable: "custom" }, { default: p((n) => [g(u(n.row.quantity ?? "-") + " " + u(n.row.accountingUnit || ""), 1)]), _: 1 })) : r("", true), e(c).visible("inQuantity") ? (a(), o(t, { key: "inQuantity", align: "center", label: "入库数", prop: "inQuantity", sortable: "custom" }, { default: p((n) => [g(u(n.row.inQuantity ?? "-") + " " + u(n.row.accountingUnit || ""), 1)]), _: 1 })) : r("", true), e(c).visible("unPackageQuantity") ? (a(), o(t, { key: "unPackageQuantity", align: "center", label: "可打包数", prop: "unPackageQuantity" }, { default: p(({ row: n }) => [n.qhseNumbers ? (a(), h("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (k) => _("qhseNumbers", n) }, u(n.unPackageQuantity || "-"), 9, ee)) : (a(), h("span", te, u(n.unPackageQuantity || "-"), 1)), g(" " + u(n.accountingUnit || ""), 1)]), _: 1 })) : r("", true), e(c).visible("packageQuantity") ? (a(), o(t, { key: "packageQuantity", align: "center", label: "已打包数（件）", prop: "packageQuantity", sortable: "custom" })) : r("", true), e(c).visible("createUserName") ? (a(), o(t, { key: "createUserName", align: "center", label: "导入人", prop: "createUserName" })) : r("", true), e(c).visible("remark") ? (a(), o(t, { key: "remark", "show-overflow-tooltip": true, align: "center", label: "备注", prop: "remark", width: "80" })) : r("", true), e(Y)(e(v).pack) ? (a(), o(t, { key: 10, align: "center", fixed: "right", label: "操作", width: "70" }, { default: p((n) => {
      var k;
      return [d(y, { disabled: Q.value.includes(`${(k = n.row) == null ? void 0 : k.id}`), icon: "el-icon-plus", size: "default", type: "success", onClick: (ne) => R(n.row) }, null, 8, ["disabled", "onClick"])];
    }), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[O, e(i).loading]]), d(e(F))]);
  };
} }, le = z(ae, [["__scopeId", "data-v-a90b957a"]]);
export {
  le as default
};
