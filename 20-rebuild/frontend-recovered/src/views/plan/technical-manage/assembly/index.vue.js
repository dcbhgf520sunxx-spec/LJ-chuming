import { ref as I } from "vue";
import { watch as M } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as H } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as w } from "vue";
import { unref as t } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as m } from "vue";
import { isRef as z } from "vue";
import { nextTick as G } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { InfoFilled as J } from "@element-plus/icons-vue";
import { ElIcon as X } from "element-plus";
import { ElTooltip as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { c as ee, _ as te } from "./module/header.vue.js";
import { _ as oe, m as ae, x as le, o as re, T as ie, c0 as U, D as C, P as ne } from "../../../../shared/runtime.js";
import { z as se } from "../../../../modules/plan-d12d7ccf.js";
import { u as de } from "../../../../modules/use-drawing-8a7ba23b.js";
import { a as ue } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const ce = { class: "app-container" }, me = { class: "head-container" }, pe = { key: 0 }, _e = { key: 1, class: "child" }, we = { style: { display: "inline-block" } }, he = ["onDblclick"], be = { key: 1, style: { color: "red", "font-size": "13px" } }, fe = { __name: "index", setup(ge) {
  const { globalProject: h, globalProjectId: k } = ae(["globalProject", "globalProjectId"]), { showDrawing: T, drawingRow: f, drawingPreview: q } = de({ pidField: "id", productTypeField: "ASSEMBLE" }), B = { add: false, edit: false, del: false, download: false }, N = I(), y = I(false), x = I(), { crud: p, columns: n, CRUD: E } = le({ title: "部件清单", sort: ["id.asc"], permission: { ...se }, optShow: { ...B }, requiredQuery: ["areaId", "monomerId", "areaBatchId"], crudApi: { ...ee }, hasPagination: true }, N), { maxHeight: F } = re({ wrapperBox: ".assembly", paginate: true, extraHeight: 40 });
  M(() => k.value, (u) => {
    u && (p.query.projectId = k.value, p.toQuery());
  }, { immediate: true, deep: true }), M(() => h.value, (u) => {
    var c, o, l;
    ((o = (c = h.value) == null ? void 0 : c.projectContentList) == null ? void 0 : o.length) > 0 && ((l = h.value) == null ? void 0 : l.projectContentList.findIndex((b) => b.no === ie.STRUCTURE.V)) > -1 ? (y.value = h.value.mode !== U.STRUCTURE.V, x.value = h.value.mode !== U.STRUCTURE.V ? "当前项目内容没有包含构件,请到合同管理中进行配置" : "当前项目模式不包含组立") : (x.value = "当前项目内容没有包含构件,请到合同管理中进行配置", y.value = true);
  }, { deep: true, immediate: true });
  function R(u) {
    return u.dataType === 2 ? u.index : u.childIndex;
  }
  E.HOOK.handleRefresh = (u, c) => {
    let o = 1;
    c.data.content = c.data.content.map((l) => (l.dataType = 2, l.index = o, o++, l.rowKey = l.id, l.hasChildren = !!l.detailDTOList.length, l));
  };
  async function L({ row: u, treeNode: c, resolve: o }) {
    try {
      const l = u.detailDTOList;
      let b = 1;
      l.length > 0 && l.map((_) => (_.dataType = 1, _.rowKey = `${u.id}__${_.id}`, _.childIndex = b, b++, _)), o(l), G(() => {
        N.value.toggleRowExpansion(u, true);
      });
    } catch (l) {
      console.log("获取翼腹板信息", l);
    }
  }
  return E.HOOK.beforeSubmit = () => !!p.form.monomerId, (u, c) => {
    var D, S, j, P, W;
    const o = Q, l = J, b = X, _ = Y, O = V("table-cell-tag"), K = V("common-table"), A = Z;
    return a(), g("div", ce, [y.value ? (a(), g(H, { key: 0 }, [v("div", me, [w(t(te), { "project-id": t(k), globalProject: t(h) }, null, 8, ["project-id", "globalProject"])]), $((a(), i(K, { ref_key: "tableRef", ref: N, data: t(p).data, "empty-text": t(p).emptyText !== "加载失败" ? t(p).emptyText : "暂无权限，请联系管理员", "max-height": t(F), "tree-props": { children: "children", hasChildren: "hasChildren" }, "row-key": "rowKey", style: { width: "100%" }, stripe: false, lazy: "", load: L, "return-source-data": "", showEmptySymbol: false }, { default: r(() => [t(n).visible("index") ? (a(), i(o, { key: 0, prop: "index", label: "序号", align: "center", width: "60" }, { default: r((e) => [e.row.dataType === 2 ? (a(), g("span", pe, s(R(e.row)), 1)) : (a(), g("span", _e, s(R(e.row)), 1))]), _: 1 })) : d("", true), t(n).visible("configName") ? (a(), i(o, { key: "configName", prop: "configName", sortable: "custom", "show-overflow-tooltip": true, label: "类型", align: "center" })) : d("", true), t(n).visible("name") ? (a(), i(o, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", align: "center" })) : d("", true), t(n).visible("serialNumber") ? (a(), i(o, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "编号" }, { header: r(() => [w(_, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: r(() => [v("div", we, [c[1] || (c[1] = v("span", null, "部件号", -1)), w(b, null, { default: r(() => [w(l)]), _: 1 })])]), _: 1 })]), default: r((e) => [w(O, { show: e.row.dataType === 2 && e.row.boolSendDirectly, name: "直发件" }, null, 8, ["show"]), v("span", { style: { cursor: "pointer" }, onDblclick: (ye) => t(q)(e.row) }, s(e.row.serialNumber), 41, he)]), _: 1 })) : d("", true), t(n).visible("specification") ? (a(), i(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", align: "center", "min-width": "120" }, { default: r((e) => [m(s(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("length") ? (a(), i(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "center", "min-width": "85px" }, { default: r((e) => [m(s(e.row.length ? e.row.length.toFixed(t(C).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("material") ? (a(), i(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" }, { default: r((e) => [m(s(e.row.material ? e.row.material : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("quantity") ? (a(), i(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "80px" }, { default: r((e) => [m(s(e.row.quantity ? e.row.quantity : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("netWeight") ? (a(), i(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: "单重(kg)", align: "center", "min-width": "80px" }, { default: r((e) => [m(s(e.row.netWeight ? e.row.netWeight.toFixed(t(C).COM_WT__KG) : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("totalNetWeight") ? (a(), i(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总重(kg)", align: "center", "min-width": "95px" }, { default: r((e) => [m(s(e.row.totalNetWeight ? e.row.totalNetWeight.toFixed(t(C).COM_WT__KG) : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("drawingNumber") ? (a(), i(o, { key: "drawingNumber", prop: "drawingNumber", "show-overflow-tooltip": true, align: "center", label: "图号", "min-width": "80px" }, { default: r((e) => [m(s(e.row.drawingNumber ? e.row.drawingNumber : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("remark") ? (a(), i(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: r((e) => [m(s(e.row.remark ? e.row.remark : "-"), 1)]), _: 1 })) : d("", true), t(n).visible("userName") ? (a(), i(o, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "导入人", align: "center", "min-width": "110" }, { default: r((e) => [m(s(e.row.userName ? e.row.userName : "-"), 1)]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[A, t(p).loading]]), w(t(ne)), w(t(ue), { modelValue: t(T), "onUpdate:modelValue": c[0] || (c[0] = (e) => z(T) ? T.value = e : null), "bool-bim": (D = t(f)) == null ? void 0 : D.boolBim, "serial-number": (S = t(f)) == null ? void 0 : S.serialNumber, productId: (j = t(f)) == null ? void 0 : j.productId, productType: (P = t(f)) == null ? void 0 : P.productType, monomerId: (W = t(f)) == null ? void 0 : W.monomerId }, null, 8, ["modelValue", "bool-bim", "serial-number", "productId", "productType", "monomerId"])], 64)) : (a(), g("span", be, s(x.value), 1))]);
  };
} }, De = oe(fe, [["__scopeId", "data-v-b3f2b386"]]);
export {
  De as default
};
