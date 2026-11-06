import { ref as v } from "vue";
import { nextTick as D } from "vue";
import { inject as T } from "vue";
import { computed as j } from "vue";
import { watch as A } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as M } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as n } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as I } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as E } from "element-plus";
import { g as K } from "../../../../../modules/manual-pack-aab80853.js";
import { a as C } from "../../../../../modules/ship-manage-3066b2ed.js";
import { _ as $, x as L, bi as V, G as z, P as G } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
const Y = { class: "app-container" }, F = { class: "head-container" }, J = ["onClick"], W = { key: 1 }, Z = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, areaBatchId: { type: [String, Number], default: void 0 } }, emits: ["add", "qhseNumbers"], setup(Q, { expose: N, emit: w }) {
  const P = { add: false, edit: false, del: false, download: false }, g = v(), { crud: r, columns: o, CRUD: _ } = L({ title: "手工打包（辅材）", sort: [], permission: { ...C }, optShow: { ...P }, crudApi: { get: K }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false, hasPagination: true }, g), f = V.AUXILIARY_MATERIAL.K, k = w, s = Q, h = v();
  D(() => {
    h.value = s.maxHeight;
  });
  const q = T("packData"), S = j(() => Object.keys(q[f]));
  A(() => [s.projectId], () => {
    r.toQuery();
  }, { immediate: true }), _.HOOK.beforeRefresh = () => {
    r.query.projectId = s.projectId, r.query.monomerId = s.monomerId, r.query.areaId = s.areaId, r.query.areaBatchId = s.areaBatchId;
  };
  function U(d) {
    k("add", d, f);
  }
  return _.HOOK.handleRefresh = (d, p) => {
    var t;
    p.data.content = (t = p.data.content) == null ? void 0 : t.map((l) => (l.productQuantity = l.unPackageQuantity, l));
  }, N({ refresh: r.toQuery }), (d, p) => {
    const t = H, l = x("common-button"), R = x("common-table"), B = E;
    return a(), y("div", Y, [M("div", F, [u(e(X))]), O((a(), n(R, { ref_key: "tableRef", ref: g, data: e(r).data, "empty-text": e(r).emptyText, "max-height": h.value, style: { width: "100%" }, onSortChange: e(r).handleSortChange }, { default: b(() => [u(t, { label: "序号", type: "index", align: "center", width: "60" }), e(o).visible("name") ? (a(), n(t, { key: "name", prop: "name", label: "名称", align: "center" })) : i("", true), e(o).visible("specification") ? (a(), n(t, { key: "specification", prop: "specification", label: "规格", align: "center" })) : i("", true), e(o).visible("accountingUnit") ? (a(), n(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" })) : i("", true), e(o).visible("mete") ? (a(), n(t, { key: "mete", prop: "mete", label: "核算量", align: "center" })) : i("", true), e(o).visible("quantity") ? (a(), n(t, { key: "quantity", prop: "quantity", sortable: "custom", label: "清单数（件）", align: "center" })) : i("", true), e(o).visible("inQuantity") ? (a(), n(t, { key: "inQuantity", prop: "inQuantity", sortable: "custom", label: "入库数（件）", align: "center" })) : i("", true), e(o).visible("unPackageQuantity") ? (a(), n(t, { key: "unPackageQuantity", prop: "unPackageQuantity", label: "可打包数（件）", align: "center" }, { default: b(({ row: c }) => [c.qhseNumbers ? (a(), y("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (m) => k("qhseNumbers", c) }, I(c.unPackageQuantity || "-"), 9, J)) : (a(), y("span", W, I(c.unPackageQuantity || "-"), 1))]), _: 1 })) : i("", true), e(o).visible("packageQuantity") ? (a(), n(t, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包数（件）", align: "center" })) : i("", true), e(o).visible("createUserName") ? (a(), n(t, { key: "createUserName", prop: "createUserName", label: "导入人", align: "center" })) : i("", true), e(o).visible("remark") ? (a(), n(t, { label: "备注", align: "center", width: "80", prop: "remark", key: "remark", "show-overflow-tooltip": true })) : i("", true), e(z)(e(C).pack) ? (a(), n(t, { key: 10, label: "操作", width: "70", align: "center", fixed: "right" }, { default: b((c) => {
      var m;
      return [u(l, { type: "success", icon: "el-icon-plus", disabled: S.value.includes(`${(m = c.row) == null ? void 0 : m.id}`), size: "default", onClick: (ee) => U(c.row) }, null, 8, ["disabled", "onClick"])];
    }), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[B, e(r).loading]]), u(e(G))]);
  };
} }, oe = $(Z, [["__scopeId", "data-v-66913453"]]);
export {
  oe as default
};
