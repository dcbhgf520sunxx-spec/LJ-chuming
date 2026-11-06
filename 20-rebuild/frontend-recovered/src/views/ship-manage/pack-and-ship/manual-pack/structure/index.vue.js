import { ref as j } from "vue";
import { inject as B } from "vue";
import { computed as K } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as n } from "vue";
import { withCtx as l } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as d } from "vue";
import { createTextVNode as g } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as V } from "element-plus";
import { b as A } from "../../../../../modules/manual-pack-aab80853.js";
import { _ as H, x as U, bi as G, V as F, br as N, bs as y, D as k, G as z, P as J } from "../../../../../shared/runtime.js";
import { a as T } from "../../../../../modules/ship-manage-3066b2ed.js";
import X from "./module/header.vue.js";
const Y = { class: "app-container" }, Z = { class: "head-container" }, ee = ["onClick"], te = { key: 1 }, ae = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, areaBatchId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add", "qhseNumbers"], setup(w, { expose: Q, emit: S }) {
  const P = { add: false, edit: false, del: false, download: false }, x = j(), { crud: s, columns: r, CRUD: v } = U({ title: "手工打包（结构）", sort: [], permission: { ...T }, optShow: { ...P }, crudApi: { get: A }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false }, x), m = G.STRUCTURE.K, C = S, u = w, q = B("packData"), R = K(() => Object.keys(q[m]));
  $(() => [u.projectId, u.workshopId, u.monomerId, u.areaId], () => {
    setTimeout(() => {
      s.toQuery();
    }, 100);
  }, { immediate: true, deep: true });
  function D(b) {
    C("add", b, m);
  }
  return v.HOOK.beforeRefresh = () => {
    s.query.projectId = u.projectId, s.query.workshopId = u.workshopId, s.query.monomerId = u.monomerId, s.query.areaId = u.areaId, s.query.areaBatchId = u.areaBatchId;
  }, v.HOOK.handleRefresh = (b, h) => {
    h.data.content = h.data.content.map((a, f) => (a.rowKey = `${m}_${Math.random()}_${f}`, a.productQuantity = a.unPackageQuantity, a.originNumberList = a.numberList && F(a.numberList) || [], a));
  }, Q({ refresh: s.toQuery }), (b, h) => {
    const a = L, f = I("common-button"), M = I("common-table"), O = V;
    return o(), _("div", Y, [c("div", Z, [p(e(X))]), E((o(), n(M, { ref_key: "tableRef", ref: x, data: e(s).data, "empty-text": e(s).emptyText, "max-height": w.maxHeight, style: { width: "100%" }, onSortChange: e(s).handleSortChange }, { default: l(() => [p(a, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("name") ? (o(), n(a, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: l(({ row: t }) => [t.workshop ? (o(), n(N, { key: 0, name: t.workshop.name }, null, 8, ["name"])) : i("", true), c("span", null, d(t.name), 1)]), _: 1 })) : i("", true), e(r).visible("serialNumber") ? (o(), n(a, { key: 1, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "120px" }, { default: l(({ row: t }) => [t.warehouseType === 1 ? (o(), n(N, { key: 0, name: "回厂返修", color: "#e64242", offset: 0 })) : i("", true), c("span", null, d(t.serialNumber), 1)]), _: 1 })) : i("", true), e(r).visible("specification") ? (o(), n(a, { key: 2, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: l(({ row: t }) => [c("span", null, d(t.specification), 1)]), _: 1 })) : i("", true), e(r).visible("length") ? (o(), n(a, { key: 3, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: l(({ row: t }) => [g(d(e(y)(t.length, e(k).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : i("", true), e(r).visible("material") ? (o(), n(a, { key: 4, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: l(({ row: t }) => [c("span", null, d(t.material), 1)]), _: 1 })) : i("", true), e(r).visible("netWeight") ? (o(), n(a, { key: 5, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: l(({ row: t }) => [g(d(e(y)(t.netWeight, e(k).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(r).visible("grossWeight") ? (o(), n(a, { key: 6, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: l(({ row: t }) => [g(d(e(y)(t.grossWeight, e(k).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(r).visible("drawingNumber") ? (o(), n(a, { key: 7, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : i("", true), e(r).visible("quantity") ? (o(), n(a, { key: 8, prop: "quantity", sortable: "custom", label: "清单数（件）", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("inQuantity") ? (o(), n(a, { key: 9, prop: "inQuantity", sortable: "custom", label: "入库数（件）", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("unPackageQuantity") ? (o(), n(a, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包数（件）", align: "center", "min-width": "80px" }, { default: l(({ row: t }) => [t.qhseNumbers ? (o(), _("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (W) => C("qhseNumbers", t) }, d(t.unPackageQuantity || "-"), 9, ee)) : (o(), _("span", te, d(t.unPackageQuantity || "-"), 1))]), _: 1 })) : i("", true), e(r).visible("packageQuantity") ? (o(), n(a, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包数", align: "center", "min-width": "80px" })) : i("", true), e(z)(e(T).pack) ? (o(), n(a, { key: 12, label: "操作", width: "70", align: "center", fixed: "right" }, { default: l(({ row: { sourceRow: t } }) => [p(f, { type: "success", icon: "el-icon-plus", disabled: R.value.includes(`${t.id}`), size: "default", onClick: (W) => D(t) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[O, e(s).loading]]), p(e(J))]);
  };
} }, le = H(ae, [["__scopeId", "data-v-2e9afa27"]]);
export {
  le as default
};
