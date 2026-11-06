import { ref as I } from "vue";
import { nextTick as W } from "vue";
import { inject as j } from "vue";
import { computed as K } from "vue";
import { watch as B } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as g } from "vue";
import { unref as e } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as o } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as p } from "vue";
import { createTextVNode as _ } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as V } from "element-plus";
import { g as A } from "../../../../../modules/manual-pack-01ad3a57.js";
import { _ as E, x as G, bw as F, V as U, br as z, bs as y, D as w, G as X } from "../../../../../shared/runtime.js";
import { m as N } from "../../../../../modules/bridge-86f96a4f.js";
import J from "./module/header.vue.js";
const Y = { class: "app-container" }, Z = { class: "head-container" }, ee = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add"], setup(Q, { expose: S, emit: T }) {
  const P = { add: false, edit: false, del: false, download: false }, k = I(), { crud: l, columns: r, CRUD: x } = G({ title: "手工打包（分段）", sort: [], permission: { ...N }, optShow: { ...P }, crudApi: { get: A }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false, hasPagination: false }, k), m = F.BOX.K, D = T, s = Q, v = I();
  W(() => {
    v.value = s.maxHeight;
  });
  const M = j("packData"), O = K(() => Object.keys(M[m]));
  B(() => [s.projectId, s.workshopId, s.monomerId, s.areaId], () => {
    l.toQuery();
  }, { immediate: true, deep: true });
  function q(b) {
    D("add", b, m);
  }
  return x.HOOK.beforeRefresh = () => {
    l.query.projectId = s.projectId, l.query.workshopId = s.workshopId, l.query.monomerId = s.monomerId, l.query.areaId = s.areaId;
  }, x.HOOK.handleRefresh = (b, f) => {
    var t;
    f.data.content = (t = f.data.boxList) == null ? void 0 : t.map((u, h) => (u.rowKey = `${m}_${Math.random()}_${h}`, u.productQuantity = u.unPackageQuantity, u.originNumberList = u.numberList && U(u.numberList) || [], u));
  }, S({ refresh: l.toQuery }), (b, f) => {
    const t = H, u = C("common-button"), h = C("common-table"), R = V;
    return a(), L("div", Y, [c("div", Z, [g(e(J))]), $((a(), o(h, { ref_key: "tableRef", ref: k, data: e(l).data, "empty-text": e(l).emptyText, "max-height": v.value, style: { width: "100%" }, onSortChange: e(l).handleSortChange }, { default: d(() => [g(t, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("name") ? (a(), o(t, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: d(({ row: n }) => [n.workshopInf ? (a(), o(z, { key: 0, name: n.workshopInf.name }, null, 8, ["name"])) : i("", true), c("span", null, p(n.name), 1)]), _: 1 })) : i("", true), e(r).visible("monomer.name") ? (a(), o(t, { key: 1, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" })) : i("", true), e(r).visible("area.name") ? (a(), o(t, { key: 2, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : i("", true), e(r).visible("serialNumber") ? (a(), o(t, { key: 3, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "100px" })) : i("", true), e(r).visible("specification") ? (a(), o(t, { key: 4, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: d(({ row: n }) => [c("span", null, p(n.specification), 1)]), _: 1 })) : i("", true), e(r).visible("length") ? (a(), o(t, { key: 5, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: d(({ row: n }) => [_(p(e(y)(n.length, e(w).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : i("", true), e(r).visible("material") ? (a(), o(t, { key: 6, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: d(({ row: n }) => [c("span", null, p(n.material), 1)]), _: 1 })) : i("", true), e(r).visible("netWeight") ? (a(), o(t, { key: 7, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: d(({ row: n }) => [_(p(e(y)(n.netWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(r).visible("grossWeight") ? (a(), o(t, { key: 8, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: d(({ row: n }) => [_(p(e(y)(n.grossWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(r).visible("drawingNumber") ? (a(), o(t, { key: 9, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : i("", true), e(r).visible("quantity") ? (a(), o(t, { key: 10, prop: "quantity", sortable: "custom", label: "清单数", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("inQuantity") ? (a(), o(t, { key: 11, prop: "inQuantity", sortable: "custom", label: "入库量", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("unPackageQuantity") ? (a(), o(t, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包量", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("packageQuantity") ? (a(), o(t, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包量", align: "center", "min-width": "80px" })) : i("", true), e(X)(e(N).pack) ? (a(), o(t, { key: 14, label: "操作", width: "70", align: "center", fixed: "right" }, { default: d(({ row: { sourceRow: n } }) => [g(u, { type: "success", icon: "el-icon-plus", disabled: O.value.includes(`${n.id}`), size: "default", onClick: (te) => q(n) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[R, e(l).loading]])]);
  };
} }, le = E(ee, [["__scopeId", "data-v-de4ff35b"]]);
export {
  le as default
};
