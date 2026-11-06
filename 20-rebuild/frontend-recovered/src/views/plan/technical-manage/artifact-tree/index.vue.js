import { ref as b } from "vue";
import { watch as F } from "vue";
import { resolveComponent as ce } from "vue";
import { resolveDirective as Pe } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as R } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as w } from "vue";
import { ElMessage as Fe } from "element-plus";
import { ElMessageBox as Oe } from "element-plus";
import { ElTableColumn as qe } from "element-plus";
import { InfoFilled as je } from "@element-plus/icons-vue";
import { ElIcon as Be } from "element-plus";
import { ElTooltip as Ue } from "element-plus";
import { ElInput as Le } from "element-plus";
import { ElButton as Ge } from "element-plus";
import { ElSwitch as $e } from "element-plus";
import { vLoading as Ke } from "element-plus";
import { a as ze, e as He, b as Qe, d as Xe } from "../../../../modules/artifact-tree-bcd3b733.js";
import { w as T } from "../../../../modules/plan-d12d7ccf.js";
import { _ as Ye, m as Je, a3 as fe, T as Ze, x as et, o as tt, br as we, D as k, p as at, G as he, m9 as q, P as ot, i as rt } from "../../../../shared/runtime.js";
import { u as it } from "../../../../modules/use-drawing-8a7ba23b.js";
import lt from "./module/header.vue.js";
import nt from "./module/change-form.vue.js";
import { b as st } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as dt } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import ut from "./module/delete-table.vue.js";
import "../../../../modules/change-reason-select-73e53277.js";
import "../../../../modules/index-8356a01a.js";
import "./module/ExcelUploadBtnV2.vue.js";
import "../../../contract/project-manage/module/enclosure-table/structure-table.vue.js";
import "./module/type-change-form.vue.js";
import "./module/change-table.vue.js";
import "./module/change-detail-table.vue.js";
import "../../../../modules/use-production-team-d8043fd6.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "./module/change-detail-form.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "./module/change-confirm-form.vue.js";
import "./module/confirm-detail.vue.js";
import "./module/repeat-detail.vue.js";
import "./module/type-detail.vue.js";
import "./module/PL-detail.vue.js";
import "./module/auto-combination.vue.js";
import "../../../../modules/assembly-template-config-631cc212.js";
import "./module/PL-config.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const mt = { class: "app-container" }, pt = { class: "head-container" }, ct = { style: { position: "relative" } }, ft = { key: 0 }, wt = { key: 1, class: "child" }, ht = { style: { display: "inline-block" } }, bt = ["onDblclick"], gt = { style: { display: "inline-block" } }, yt = { key: 0 }, _t = { key: 1 }, vt = { key: 0, class: "status-mark" }, kt = { key: 1, style: { color: "red", "font-size": "13px" } }, xt = { __name: "index", setup(Tt) {
  const { globalProject: x, globalProjectId: j } = Je(["globalProject", "globalProjectId"]), { showDrawing: B, drawingRow: f, drawingPreview: be } = it({ pidField: "id", typeField: "productType" }), I = b(false), C = b(false), E = b(true), N = b(false), S = b(), W = b([]), U = b({});
  F([() => I.value, () => C.value], ([a, r]) => {
    !a && !r && (B.value = false);
  }), F(() => B.value, (a) => {
    var r, o, l, h;
    a && ((r = f.value) != null && r.productType && ((o = f.value) == null ? void 0 : o.productType) & fe.ARTIFACT.V && (I.value = true), (l = f.value) != null && l.productType && !(((h = f.value) == null ? void 0 : h.productType) & fe.ARTIFACT.V) && (C.value = true));
  }), F(() => x.value, (a) => {
    var r, o, l;
    ((o = (r = x.value) == null ? void 0 : r.projectContentList) == null ? void 0 : o.length) > 0 ? E.value = ((l = x.value) == null ? void 0 : l.projectContentList.findIndex((h) => h.no === Ze.STRUCTURE.V)) > -1 : E.value = true;
  }, { deep: true, immediate: true });
  const ge = { add: false, edit: false, del: false, download: false }, A = b(), v = b({}), M = b(false), V = b([]), L = b({}), { crud: c, columns: u, CRUD: P } = et({ title: "零构件清单", sort: [], permission: { ...T }, optShow: { ...ge }, invisibleColumns: ["createTime", "updateTime", "printedCode"], crudApi: { ...ze }, requiredQuery: ["areaId"], queryOnPresenterCreated: false }, A), { maxHeight: ye } = tt({ wrapperBox: ".artifact-tree", paginate: true, extraHeight: 40 });
  function _e(a, r, o) {
    if (!he(T.edit)) return;
    r.property === "remark" && !a.edit && a.dataType === 2 && (a.edit = true);
  }
  function ve(a) {
    a.remark = a.originalRemark, a.edit = false;
  }
  function keepRemarkEditorFocus(event) {
    // Keep the inline editor from shifting between pointer down and click.
    event.preventDefault();
  }
  async function ke(a) {
    if (!he(T.edit)) return;
    try {
      a.editLoading = true, await He([{ id: a.id, remark: a.remark }]), Fe.success("修改成功"), c.toQuery();
    } catch (r) {
      a.remark = a.originalRemark, console.log("编辑备注", r);
    } finally {
      a.edit = false, a.editLoading = false;
    }
  }
  function G(a) {
    return a.dataType === 1 ? a.index : a.dataType === 0 ? a.childIndex : a.index;
  }
  function xe(a) {
    v.value = a, M.value = true;
  }
  function Te(a) {
    v.value = a, v.value.area = V.value.find((r) => r.id === Number(c.query.areaId)) || {}, W.value = [], N.value = true;
  }
  function Ie() {
    v.value = {}, U.value = V.value.find((a) => a.id === Number(c.query.areaId)) || {}, W.value = c.selections.map((a) => a.id), N.value = true;
  }
  function Ce({ row: a, rowIndex: r }) {
    return a.abnormal === 1 ? "abnormal-row" : a.children ? "parent-row" : "hidden-select";
  }
  function Ne({ row: a, rowIndex: r }) {
    return a.abnormal === 1 ? "abnormal-row" : a.children ? "parent-row" : "hidden-select";
  }
  P.HOOK.handleRefresh = (a, r) => {
    a.data = [];
    let o = 1;
    r.data.content = r.data.content.map((l) => (l.project = x.value, l.edit = false, l.originalRemark = l.remark, l.editLoading = false, l.monomerId = a.query.monomerId, l.areaId = a.query.areaId, l.dataType = 2, l.index = o, o++, l.machinePartDTOList = [], l.children = [], l.rowKey = l.id, l.hasChildren = !!l.hasMachinePart, l.rowKey = l.id, l));
  };
  async function Se(a, r) {
    try {
      const o = r ? "启用" : "暂停";
      await Oe.confirm("确定" + o + "?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const l = { status: r };
      await Qe(a.dataType, a.id, l), c.notify(`“${a.serialNumber}”已【${o}】`, P.NOTIFICATION_TYPE.SUCCESS);
    } catch (o) {
      console.log("修改零构件状态", o), a.boolStatusEnum = !a.boolStatusEnum;
    }
  }
  P.HOOK.beforeSubmit = () => (c.form.projectId = j, !!c.form.projectId);
  async function Ae({ row: a, treeNode: r, resolve: o }) {
    if (a.dataType === 2) {
      const { content: l } = await Xe({ artifactId: a.id });
      o(l.map((h, D) => ({ ...h, dataType: 1, rowKey: `${a.id}__${h.id}`, hasChildren: Array.isArray(h.assembleMachinePartDTOList) && h.assembleMachinePartDTOList.length > 0, index: D + 1 })));
      return;
    }
    if (a.dataType === 1) {
      Array.isArray(a.assembleMachinePartDTOList) && a.assembleMachinePartDTOList.length > 0 ? o(a.assembleMachinePartDTOList.map((l, h) => ({ ...l, dataType: 0, rowKey: `artifact_${a.id}_machine_${l.id}`, childIndex: h + 1 }))) : o([]);
      return;
    }
    o([]);
  }
  function De(a) {
    V.value = a;
  }
  function Re(a) {
    L.value = a;
  }
  function $() {
    rt(v.value) ? A.value.refreshParent(v.value) : c.selections.length > 0 && c.selections.forEach((a) => {
      A.value.refreshParent(a);
    }), c.toQuery();
  }
  return (a, r) => {
    var Q, X, Y, J, Z, ee, te, ae, oe, re, ie, le, ne, se, de, ue, me, pe;
    const o = qe, l = je, h = Be, D = Ue, Ee = Le, K = Ge, We = $e, z = ce("common-button"), Me = ce("common-table"), H = Pe("permission"), Ve = Ke;
    return i(), g("div", mt, [E.value ? (i(), g(R, { key: 0 }, [_("div", pt, [m(t(lt), { ref_key: "headerRef", ref: S, globalProject: t(x), "project-id": t(j), onGetAreaData: De, onGetMonomerData: Re, onBatchRemove: Ie }, null, 8, ["globalProject", "project-id"])]), _("div", ct, [O((i(), d(Me, { ref_key: "tableRef", ref: A, "cell-class-name": Ne, data: t(c).data, "empty-text": t(c).emptyText, load: Ae, "max-height": t(ye), "row-class-name": Ce, showEmptySymbol: false, stripe: false, "tree-props": { children: "children", hasChildren: "hasChildren" }, lazy: "", "return-source-data": "", "row-key": "rowKey", style: { width: "100%" }, onSortChange: t(c).handleSortChange, onSelectionChange: t(c).selectionChangeHandler, onRowDblclick: _e }, { default: n(() => [m(o, { key: "selection", type: "selection", width: "55", fixed: "left" }), t(u).visible("index") ? (i(), d(o, { key: 0, align: "center", label: "序号", prop: "index", width: "80", fixed: "left" }, { default: n((e) => [e.row.children ? (i(), g("span", ft, p(G(e.row)), 1)) : (i(), g("span", wt, p(G(e.row)), 1))]), _: 1 })) : s("", true), t(u).visible("structureType") ? (i(), d(o, { key: "structureType", prop: "structureType", sortable: "custom", "show-overflow-tooltip": true, label: "结构类型", "min-width": "100px" })) : s("", true), t(u).visible("name") ? (i(), d(o, { key: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100px", prop: "name", sortable: "custom" })) : s("", true), t(u).visible("serialNumber") ? (i(), d(o, { key: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140px", prop: "serialNumber", sortable: "custom" }, { header: n(() => [m(D, { content: "双击编号可预览图纸", class: "item", effect: "light", placement: "top" }, { default: n(() => [_("div", ht, [r[4] || (r[4] = _("span", { style: { "margin-left": "10px" } }, "编号", -1)), m(h, null, { default: n(() => [m(l)]), _: 1 })])]), _: 1 })]), default: n((e) => [m(we, { show: e.row.dataType !== 2 && e.row.boolSendDirectly, name: "直发件" }, null, 8, ["show"]), m(we, { show: e.row.dataType !== 2 && e.row.relationType === 8, name: "配套件" }, null, 8, ["show"]), _("span", { style: { cursor: "pointer", "margin-left": "10px" }, onDblclick: (y) => t(be)(e.row) }, p(e.row.serialNumber), 41, bt)]), _: 1 })) : s("", true), t(u).visible("specification") ? (i(), d(o, { key: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", prop: "specification", sortable: "custom" }, { default: n((e) => [w(p(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("length") ? (i(), d(o, { key: "length", label: `长度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "85px", prop: "length", sortable: "custom" }, { default: n((e) => [w(p(e.row.length ? e.row.length.toFixed(t(k).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("material") ? (i(), d(o, { key: "material", "show-overflow-tooltip": true, align: "center", label: "材质", "min-width": "80px", prop: "material", sortable: "custom" }, { default: n((e) => [w(p(e.row.material ? e.row.material : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("quantity") ? (i(), d(o, { key: "quantity", align: "left", label: "数量", "min-width": "80px", prop: "quantity", sortable: "custom" }, { default: n((e) => [w(p(e.row.quantity ? e.row.quantity : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("netWeight") ? (i(), d(o, { key: "netWeight", label: `单净重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "netWeight", sortable: "custom" }, { default: n((e) => [w(p(e.row.netWeight ? e.row.netWeight.toFixed(t(k).COM_WT__KG) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("totalNetWeight") ? (i(), d(o, { key: "totalNetWeight", label: `总净重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "95px", prop: "totalNetWeight" }, { default: n((e) => [w(p(e.row.totalNetWeight ? e.row.totalNetWeight.toFixed(t(k).COM_WT__KG) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("grossWeight") ? (i(), d(o, { key: "grossWeight", label: `单毛重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "grossWeight", sortable: "custom" }, { default: n((e) => [w(p(e.row.grossWeight ? e.row.grossWeight.toFixed(t(k).COM_WT__KG) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("totalGrossWeight") ? (i(), d(o, { key: "totalGrossWeight", label: `总毛重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "95px", prop: "totalGrossWeight" }, { default: n((e) => [w(p(e.row.totalGrossWeight ? e.row.totalGrossWeight.toFixed(t(k).COM_WT__KG) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("drawingWeight") ? (i(), d(o, { prop: "drawingWeight", key: "drawingWeight", "show-overflow-tooltip": true, label: "图纸单重(kg)", align: "left", "min-width": "95px" })) : s("", true), t(u).visible("totalDrawingWeight") ? (i(), d(o, { prop: "totalDrawingWeight", key: "totalDrawingWeight", "show-overflow-tooltip": true, label: "图纸总重(kg)", align: "left", "min-width": "95px" })) : s("", true), t(u).visible("surfaceArea") ? (i(), d(o, { key: "surfaceArea", label: `单面积
(㎡)`, align: "left", "min-width": "80px", prop: "surfaceArea", sortable: "custom" }, { default: n((e) => [w(p(e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(k).COM_AREA__M2) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("totalSurfaceArea") ? (i(), d(o, { key: "totalSurfaceArea", label: `总面积
(㎡)`, align: "left", "min-width": "80px", prop: "totalSurfaceArea", sortable: "custom" }, { default: n((e) => [w(p(e.row.totalSurfaceArea ? e.row.totalSurfaceArea.toFixed(t(k).COM_AREA__M2) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("topFlangeArea") ? (i(), d(o, { key: "topFlangeArea", prop: "topFlangeArea", sortable: "custom", label: `上翼缘面积
(㎡)`, align: "left", "min-width": "90px" }, { default: n((e) => [w(p(e.row.topFlangeArea ? e.row.topFlangeArea.toFixed(t(k).COM_AREA__M2) : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("drawingNumber") ? (i(), d(o, { key: "drawingNumber", "show-overflow-tooltip": true, label: "图号", "min-width": "100px", prop: "drawingNumber", sortable: "custom" }, { default: n((e) => [w(p(e.row.drawingNumber ? e.row.drawingNumber : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("remark") ? (i(), d(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", prop: "remark", width: "350px" }, { header: n(() => [m(D, { content: "双击备注可修改", class: "item", effect: "light", placement: "top" }, { default: n(() => [_("div", gt, [r[5] || (r[5] = _("span", null, "备注", -1)), m(h, null, { default: n(() => [m(l)]), _: 1 })])]), _: 1 })]), default: n((e) => [e.row.dataType === 2 ? (i(), g(R, { key: 0 }, [e.row.edit ? (i(), g("span", _t, [m(Ee, { modelValue: e.row.remark, "onUpdate:modelValue": (y) => e.row.remark = y, maxlength: 64, rows: 1, clearable: "", size: "default", style: { width: "180px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), m(K, { loading: e.row.editLoading, size: "default", type: "primary", onMousedown: keepRemarkEditorFocus, onClick: (y) => ke(e.row) }, { default: n(() => r[6] || (r[6] = [w("保存")])), _: 2, __: [6] }, 1032, ["loading", "onClick"]), m(K, { size: "default", type: "info", onMousedown: keepRemarkEditorFocus, onClick: (y) => ve(e.row) }, { default: n(() => r[7] || (r[7] = [w("取消")])), _: 2, __: [7] }, 1032, ["onClick"])])) : (i(), g("span", yt, p(e.row.remark || "-"), 1))], 64)) : (i(), g(R, { key: 1 }, [w(p(e.row.remark || "-"), 1)], 64))]), _: 1 })) : s("", true), t(u).visible("userName") ? (i(), d(o, { key: "userName", "show-overflow-tooltip": true, label: "导入人", "min-width": "110", prop: "userName" }, { default: n((e) => [w(p(e.row.userName ? e.row.userName : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("createTime") ? (i(), d(o, { key: "createTime", label: "上传时间", "min-width": "160px", prop: "createTime" }, { default: n((e) => [_("div", null, p(e.row.createTime ? t(at)(e.row.createTime, "{y}-{m}-{d}  {h}:{i}:{s}") : "-"), 1)]), _: 1 })) : s("", true), t(u).visible("printedCode") ? (i(), d(o, { label: "喷印编码", key: "printedCode", prop: "printedCode", "min-width": "160px" }, { default: n((e) => [_("div", null, p(e.row.printedCode || "-"), 1)]), _: 1 })) : s("", true), t(u).visible("status") ? (i(), d(o, { key: "status", align: "center", fixed: "right", label: "状态", prop: "status", width: "80px" }, { default: n((e) => [m(We, { modelValue: e.row.boolStatusEnum, "onUpdate:modelValue": (y) => e.row.boolStatusEnum = y, "active-value": true, disabled: !t(he)(t(T).edit), "inactive-value": false, "active-color": "#13ce66", onChange: (y) => Se(e.row, e.row.boolStatusEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : s("", true), t(he)([...t(T).editNum]) ? (i(), d(o, { key: 23, align: "center", fixed: "right", label: "操作", width: "150px" }, { default: n((e) => [e.row.dataType === 2 ? (i(), g(R, { key: 0 }, [O(m(z, { disabled: !e.row.boolStatusEnum, icon: "el-icon-edit", size: "default", onClick: (y) => xe(e.row) }, null, 8, ["disabled", "onClick"]), [[H, t(T).editNum]]), O(m(z, { disabled: !e.row.boolStatusEnum, icon: "el-icon-delete", size: "default", type: "danger", onClick: (y) => Te(e.row) }, null, 8, ["disabled", "onClick"]), [[H, t(T).changeBtn]])], 64)) : s("", true)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[Ve, t(c).loading]]), ((X = (Q = S.value) == null ? void 0 : Q.inventoryReviewedData) == null ? void 0 : X.inventoryReviewedEnum) === t(q).FIXUP_RECORD.V || ((J = (Y = S.value) == null ? void 0 : Y.inventoryReviewedData) == null ? void 0 : J.inventoryReviewedEnum) === t(q).UNAUDITED.V ? (i(), g("div", vt, p(t(q).VL[(ee = (Z = S.value) == null ? void 0 : Z.inventoryReviewedData) == null ? void 0 : ee.inventoryReviewedEnum]), 1)) : s("", true)]), m(t(ot)), m(t(nt), { modelValue: M.value, "onUpdate:modelValue": r[0] || (r[0] = (e) => M.value = e), detailInfo: v.value, query: t(c).query, onSuccess: $ }, null, 8, ["modelValue", "detailInfo", "query"]), m(t(ut), { modelValue: N.value, "onUpdate:modelValue": r[1] || (r[1] = (e) => N.value = e), currentMonomer: L.value, detailInfo: v.value, artifactIds: W.value, areaInfo: U.value, projectInfo: t(x), query: t(c).query, onSuccess: $ }, null, 8, ["modelValue", "currentMonomer", "detailInfo", "artifactIds", "areaInfo", "projectInfo", "query"]), m(t(st), { visible: I.value, "onUpdate:visible": r[2] || (r[2] = (e) => I.value = e), "area-id": t(c).query.areaId, "bool-bim": (te = t(f)) == null ? void 0 : te.boolBim, drawingSN: (ae = t(f)) == null ? void 0 : ae.drawingSN, "monomer-id": (oe = t(f)) == null ? void 0 : oe.monomerId, productId: (re = t(f)) == null ? void 0 : re.productId, productType: (ie = t(f)) == null ? void 0 : ie.productType, "serial-number": (le = t(f)) == null ? void 0 : le.serialNumber }, null, 8, ["visible", "area-id", "bool-bim", "drawingSN", "monomer-id", "productId", "productType", "serial-number"]), m(t(dt), { modelValue: C.value, "onUpdate:modelValue": r[3] || (r[3] = (e) => C.value = e), "bool-bim": (ne = t(f)) == null ? void 0 : ne.boolBim, drawingSN: (se = t(f)) == null ? void 0 : se.drawingSN, "monomer-id": (de = t(f)) == null ? void 0 : de.monomerId, productId: (ue = t(f)) == null ? void 0 : ue.productId, productType: (me = t(f)) == null ? void 0 : me.productType, "serial-number": (pe = t(f)) == null ? void 0 : pe.serialNumber }, null, 8, ["modelValue", "bool-bim", "drawingSN", "monomer-id", "productId", "productType", "serial-number"])], 64)) : (i(), g("span", kt, "当前项目内容没有包含构件,请到合同管理中进行配置"))]);
  };
} }, na = Ye(xt, [["__scopeId", "data-v-5fa71435"]]);
export {
  na as default
};
