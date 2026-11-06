import { ref as T } from "vue";
import { inject as D } from "vue";
import { computed as j } from "vue";
import { watch as A } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as p } from "vue";
import { ElTableColumn as O } from "element-plus";
import { vLoading as $ } from "element-plus";
import { g as K } from "../../../../../modules/manual-pack-695cccc1.js";
import { _ as U, x as B, oc as x, bi as E, V as H, br as V, G as z, P as G } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
const Y = { class: "app-container" }, F = { class: "head-container" }, J = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add"], setup(_, { expose: v, emit: I }) {
  const C = { add: false, edit: false, del: false, download: false }, g = T(), { crud: r, columns: s, CRUD: k } = B({ title: "手工打包（配套件）", sort: [], permission: { ...x }, optShow: { ...C }, crudApi: { get: K }, invisibleColumns: ["packageQuantity"], queryOnPresenterCreated: false }, g), b = E.AUXILIARY_MATERIAL.K, Q = I, l = _, S = D("packData"), P = j(() => Object.keys(S[b]));
  A(() => [l.projectId, l.workshopId, l.monomerId, l.areaId], () => {
    r.toQuery();
  }, { immediate: true, deep: true });
  function N(f) {
    Q("add", f, b);
  }
  return k.HOOK.beforeRefresh = () => {
    r.query.projectId = l.projectId, r.query.workshopId = l.workshopId, r.query.monomerId = l.monomerId, r.query.areaId = l.areaId;
  }, k.HOOK.handleRefresh = (f, y) => {
    y.data.content = y.data.content.map((e, h) => (e.rowKey = `${b}_${Math.random()}_${h}`, e.productQuantity = e.unPackageQuantity, e.originNumberList = e.numberList && H(e.numberList) || [], e));
  }, v({ refresh: r.toQuery }), (f, y) => {
    const e = O, h = w("common-button"), R = w("common-table"), q = $;
    return n(), L("div", Y, [d("div", F, [m(t(X))]), M((n(), o(R, { ref_key: "tableRef", ref: g, data: t(r).data, "empty-text": t(r).emptyText, "max-height": _.maxHeight, "show-empty-symbol": false, style: { width: "100%" }, onSortChange: t(r).handleSortChange }, { default: u(() => [m(e, { label: "序号", type: "index", align: "center", width: "60" }), t(s).visible("name") ? (n(), o(e, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: u(({ row: a }) => [a.workshop ? (n(), o(V, { key: 0, name: a.workshop.name }, null, 8, ["name"])) : i("", true), d("span", null, p(a.name), 1)]), _: 1 })) : i("", true), t(s).visible("monomer.name") ? (n(), o(e, { key: 1, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" }, { default: u(({ row: a }) => {
      var c;
      return [d("span", null, p(a.monomer ? (c = a.monomer) == null ? void 0 : c.name : "-"), 1)];
    }), _: 1 })) : i("", true), t(s).visible("area.name") ? (n(), o(e, { key: 2, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" }, { default: u(({ row: a }) => {
      var c;
      return [d("span", null, p(a.area ? (c = a.area) == null ? void 0 : c.name : "-"), 1)];
    }), _: 1 })) : i("", true), t(s).visible("measureUnit") ? (n(), o(e, { key: 3, "show-overflow-tooltip": true, prop: "measureUnit", label: "单位", align: "center", width: "100px" })) : i("", true), t(s).visible("specification") ? (n(), o(e, { key: 4, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", align: "center", label: "规格", "min-width": "120px" }, { default: u(({ row: a }) => [d("span", null, p(a.specification), 1)]), _: 1 })) : i("", true), t(s).visible("quantity") ? (n(), o(e, { key: 5, prop: "quantity", sortable: "custom", label: "清单数", align: "center", "min-width": "80px" })) : i("", true), t(s).visible("inQuantity") ? (n(), o(e, { key: 6, prop: "inQuantity", sortable: "custom", label: "入库量", align: "center", "min-width": "80px" })) : i("", true), t(s).visible("unPackageQuantity") ? (n(), o(e, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包量", align: "center", "min-width": "80px" })) : i("", true), t(s).visible("packageQuantity") ? (n(), o(e, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包量", align: "center", "min-width": "80px" })) : i("", true), t(z)(t(x).pack) ? (n(), o(e, { key: 9, label: "操作", width: "70", align: "center", fixed: "right" }, { default: u(({ row: { sourceRow: a } }) => [m(h, { type: "success", icon: "el-icon-plus", disabled: P.value.includes(`${a.id}`), size: "default", onClick: (c) => N(a) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[q, t(r).loading]]), m(t(G))]);
  };
} }, ae = U(J, [["__scopeId", "data-v-941d26bf"]]);
export {
  ae as default
};
