import { ref as w } from "vue";
import { provide as le } from "vue";
import { watch as ie } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as Re } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as F } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as h } from "vue";
import { unref as a } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as u } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as N } from "vue";
import { isRef as Te } from "vue";
import { ElMessageBox as Le } from "element-plus";
import { ElMessage as G } from "element-plus";
import { ElTableColumn as Pe } from "element-plus";
import { InfoFilled as Oe } from "@element-plus/icons-vue";
import { ElIcon as Me } from "element-plus";
import { ElTooltip as xe } from "element-plus";
import { ElInputNumber as qe } from "element-plus";
import { ElInput as Ue } from "element-plus";
import { ElSwitch as Ae } from "element-plus";
import { ElPopconfirm as De } from "element-plus";
import { vLoading as Be } from "element-plus";
import { _ as Fe, m as Ge, T as n, x as We, m6 as P, o as $e, i as W, js as je, D as g, ml as Qe, G as $, m8 as I, P as He, mm as ze, fK as ne, ma as Je } from "../../../../shared/runtime.js";
import { a as Ke } from "../../../../modules/base-6bc46ddf.js";
import { e as E } from "../../../../modules/plan-d12d7ccf.js";
import Ye from "./module/header.vue.js";
import Xe from "./module/form.vue.js";
import Ze from "../components/simple-drawing/index.vue.js";
import { u as et } from "../../../../modules/use-drawing-8a7ba23b.js";
import { _ as tt } from "../../../../modules/SingleFileUploadBtn-17bec156.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../contract/project-manage/module/enclosure-table/pressed-support-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/sandwich-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/pressed-color-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/truss-support-table.vue.js";
import "../../technical-data-manage/components/drawing-upload-btn/index.vue.js";
import "../../../../modules/index-ce9deea8.js";
import "../components/simple-drawing/simple-jpg.vue.js";
const at = { class: "app-container" }, ot = { class: "head-container" }, lt = { style: { display: "inline-block" } }, it = ["onDblclick"], nt = { key: 1 }, rt = { key: 1 }, dt = { key: 1 }, ut = { key: 1 }, st = { key: 1 }, ct = { key: 1 }, mt = { key: 1 }, yt = { key: 1 }, ft = { key: 1 }, ht = { key: 1, style: { color: "red", "font-size": "13px" } }, pt = { __name: "index", setup(gt) {
  const { globalProject: j, globalProjectId: C } = Ge(["globalProject", "globalProjectId"]), { showDrawing: O, drawingRow: Q, drawingPreview: H } = et({}), v = w([]), M = w(true), x = w({}), re = w(), de = { key: "id", label: "plateType", value: "id" }, ue = { key: "id", label: "serialNumber", value: "id" }, z = w(true);
  le("plateOption", v), le("technicalTypeStatus", M);
  const q = w(false), J = w({}), R = w([]), se = [{ name: "压型彩板", no: n.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: n.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: n.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: n.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: n.BENDING.V, alias: "ENCLOSURE" }], ce = { add: false, edit: false, del: false, download: false }, K = w(), { crud: o, columns: y, CRUD: T } = We({ title: "围护清单", sort: ["id.desc"], permission: { ...E }, optShow: { ...ce }, requiredQuery: ["areaId"], crudApi: { ...P }, hasPagination: true }, K), { maxHeight: me } = $e({ wrapperBox: ".enclosureList", paginate: true, extraHeight: 40 }), Y = { serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: (e, l) => o.query.category === n.BENDING.V ? !!e : true, message: "展开宽度必填", trigger: "change" }], plateId: [{ validator: (e, l) => o.query.category !== n.BENDING.V ? !!e : true, message: "请选择板型", trigger: "change" }], width: [{ validator: (e, l) => o.query.category !== n.BENDING.V ? !!e : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (e, l) => o.query.category !== n.TRUSS_FLOOR_PLATE.V ? !!e : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (e, l) => o.query.category === n.BENDING.V ? !!e : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (e, l) => o.query.category === n.BENDING.V || o.query.category === n.PROFILED_PLATE.V ? !!e : true, message: "请输入颜色", trigger: "blur" }] };
  function ye({ row: e, column: l }) {
    if (!e) return;
    const r = Y;
    let _ = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[l.property] === false && (_ = ne(l.property, r[l.property], e)), _ && (e.verify[l.property] = true)), _ ? "" : "mask-td";
  }
  ie(() => C.value, (e) => {
    e && (ge(), o.query.projectId = C.value, o.toQuery());
  }, { immediate: true, deep: true }), ie(() => j.value, (e) => {
    R.value = [], W(e) && (se.forEach((l) => {
      e.projectContentList.findIndex((r) => Number(r.no) === l.no) > -1 && R.value.push(l);
    }), z.value = R.value.length > 0);
  }, { deep: true, immediate: true }), fe();
  async function fe() {
    try {
      const { technicalType: e = true } = await Ke();
      M.value = e;
    } catch (e) {
      console.log("获取技术交底配置状态", e), M.value = true;
    }
  }
  async function he(e, l) {
    try {
      const r = l === 1 ? "启用" : "暂停";
      await Le.confirm("确定" + r + "?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Je(e.id, { boolStatusEnum: !!l }), o.notify(`“${e.name}”已【${r}】`, T.NOTIFICATION_TYPE.SUCCESS), o.toQuery();
    } catch (r) {
      console.log("修改围护状态", r), e.boolStatusEnum = e.boolStatusEnum === I.PROCESS.V ? I.PAUSE.V : I.PROCESS.V;
    }
  }
  function pe() {
    G.success("上传成功"), o.toQuery();
  }
  function X() {
    v.value = o.query.category !== n.BENDING.V ? x.value[o.query.category] : [];
  }
  async function ge() {
    try {
      const e = await je(C.value);
      W(e) && (x.value = { [n.PROFILED_PLATE.V]: e.profiledPlateList || [], [n.PRESSURE_BEARING_PLATE.V]: e.pressureBearingPlateList || [], [n.TRUSS_FLOOR_PLATE.V]: e.trussFloorPlateList || [], [n.SANDWICH_BOARD.V]: e.sandwichBoardList || [] }), X();
    } catch (e) {
      console.log("获取技术交底", e);
    }
  }
  function _e(e, l) {
    const r = v.value.find((_) => _.id === e.plateId);
    o.query.category === n.TRUSS_FLOOR_PLATE.V ? (o.data[l].plate = r.serialNumber, o.data[l].weightMeter = r.weightMeter) : (o.data[l].plate = r.plateType, o.data[l].brand = r.brand, o.data[l].thickness = r.thickness, o.data[l].color = r.colour), o.data[l].width = r.effectiveWidth, k(e);
  }
  function k(e) {
    e.length && e.quantity && (e.totalLength = e.length * e.quantity / 1e3, Z(e)), o.query.category === n.BENDING.V ? e.length && e.quantity && e.unfoldedWidth && (e.totalArea = e.unfoldedWidth * e.length * e.quantity / 1e6) : e.length && e.quantity && e.width && (e.totalArea = e.width * e.length * e.quantity / 1e6);
  }
  function Z(e) {
    o.query.category === n.BENDING.V || o.query.category === n.PROFILED_PLATE.V || o.query.category === n.PRESSURE_BEARING_PLATE.V ? e.unfoldedWidth && e.thickness && e.totalLength && (e.weight = e.unfoldedWidth / 1e3 * e.thickness * e.totalLength * 7.85) : o.query.category === n.TRUSS_FLOOR_PLATE.V && e.weightMeter && e.totalLength && (e.weight = e.weightMeter * e.totalLength);
  }
  function we() {
    if (o.query.category !== n.BENDING.V && v.value.length <= 0) {
      G.error("请先前往合同管理添加技术交底");
      return;
    }
    o.data.unshift({ id: void 0, areaId: o.query.areaId, isModify: true, dataIndex: o.data.length });
  }
  const ee = w({});
  function Ee(e) {
    ee.value = JSON.parse(JSON.stringify(e));
    const l = v.value.find((r) => r.plateType === e.plate);
    e.plateId = W(l) ? l.id : void 0, e.isModify = true;
  }
  async function ve(e) {
    try {
      await P.del(e.id), o.notify("删除成功", T.NOTIFICATION_TYPE.SUCCESS), o.toQuery();
    } catch (l) {
      console.log("删除", l);
    }
  }
  function be(e) {
    if (e.id) e = Object.assign(e, JSON.parse(JSON.stringify(ee.value))), e.isModify = false;
    else {
      const l = o.data.findIndex((r) => r.dataIndex === e.dataIndex);
      o.data.splice(l, 1);
    }
  }
  async function Se(e) {
    o.query.category !== n.BENDING.V && o.data.map((p) => {
      if (!p.isModify && p.plate) {
        const U = v.value.find((A) => A.plateType === p.plate);
        p.plateId = U.id;
      }
    });
    const l = Y;
    let r = true;
    e.verify = {};
    for (const p in l) e.verify[p] = ne(p, l[p], e), e.verify[p] || (r = false);
    if (console.log(e), !r) {
      G.error("请填写表格中标红数据");
      return;
    }
    const _ = e.id ? "修改" : "新增";
    try {
      e.id ? await P.edit(e) : await P.add(e), o.notify(`${_}成功`, T.NOTIFICATION_TYPE.SUCCESS), e.isModify = false;
    } catch (p) {
      console.log(_, p);
    }
  }
  function Ve(e) {
    q.value = true, J.value = e;
  }
  return T.HOOK.handleRefresh = (e, l) => (l.data.content.length > 0 && l.data.content.forEach((r) => {
    r.type = e.query.type;
  }), l), (e, l) => {
    var ae, oe;
    const r = Pe, _ = Oe, p = Me, U = xe, A = B("common-select"), b = qe, te = Ue, S = B("common-button"), Ne = Ae, ke = De, Ie = B("common-table"), D = Re("permission"), Ce = Be;
    return i(), f("div", at, [z.value ? (i(), f(F, { key: 0 }, [V("div", ot, [h(a(Ye), { "project-id": a(C), onTableAdd: we, "table-data": x.value, globalProject: a(j), typeOption: R.value, onCategoryChange: X }, null, 8, ["project-id", "table-data", "globalProject", "typeOption"])]), L((i(), u(Ie, { ref_key: "tableRef", ref: K, data: a(o).data, "empty-text": a(o).emptyText, "max-height": a(me), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, onSortChange: a(o).handleSortChange, class: "enclosure-table", "cell-class-name": ye }, { default: s(() => [h(r, { label: "序号", type: "index", align: "center", width: "55" }), a(y).visible("name") ? (i(), u(r, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100" }, { default: s((t) => [V("div", null, m(t.row.name), 1)]), _: 1 })) : c("", true), a(y).visible("serialNumber") && a(o).query.category !== a(n).BENDING.V ? (i(), u(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { default: s((t) => [V("div", null, m(t.row.serialNumber), 1)]), _: 1 })) : c("", true), a(y).visible("serialNumber") && a(o).query.category === a(n).BENDING.V ? (i(), u(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { header: s(() => [h(U, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: s(() => [V("div", lt, [l[2] || (l[2] = V("span", null, "编号", -1)), h(p, null, { default: s(() => [h(_)]), _: 1 })])]), _: 1 })]), default: s((t) => [V("span", { style: { cursor: "pointer" }, onDblclick: (d) => a(H)(t.row) }, m(t.row.serialNumber), 41, it)]), _: 1 })) : c("", true), a(y).visible("plateId") && a(o).query.category !== a(n).BENDING.V ? (i(), u(r, { key: "plateId", prop: "plateId", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: s((t) => [t.row.isModify && !t.row.inProductionQuantity ? (i(), u(A, { key: 0, modelValue: t.row.plateId, "onUpdate:modelValue": (d) => t.row.plateId = d, options: v.value, type: "other", dataStructure: a(o).query.category === a(n).TRUSS_FLOOR_PLATE.V ? ue : de, size: "default", placeholder: "板型", onChange: (d) => _e(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (i(), f("div", nt, m(t.row.plate ? t.row.plate : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("width") && a(o).query.category !== a(n).BENDING.V ? (i(), u(r, { key: "width", prop: "width", "show-overflow-tooltip": true, label: a(o).query.category === a(n).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: s((t) => [t.row.isModify && a(o).query.category !== a(n).PROFILED_PLATE.V && a(o).query.category !== a(n).PRESSURE_BEARING_PLATE.V && !t.row.inProductionQuantity ? (i(), u(b, { key: 0, modelValue: t.row.width, "onUpdate:modelValue": (d) => t.row.width = d, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: a(g).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (d) => k(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (i(), f("div", rt, m(t.row.width ? t.row.width.toFixed(a(g).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : c("", true), a(y).visible("unfoldedWidth") && (a(o).query.category === a(n).BENDING.V || a(o).query.category === a(n).PROFILED_PLATE.V || a(o).query.category === a(n).PRESSURE_BEARING_PLATE.V) ? (i(), u(r, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: s((t) => [t.row.isModify && !t.row.inProductionQuantity && a(o).query.category === a(n).BENDING.V ? (i(), u(b, { key: 0, modelValue: t.row.unfoldedWidth, "onUpdate:modelValue": (d) => t.row.unfoldedWidth = d, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: a(g).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (d) => k(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (i(), f("div", dt, m(t.row.unfoldedWidth ? t.row.unfoldedWidth.toFixed(a(g).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : c("", true), a(o).query.category === a(n).BENDING.V ? (i(), u(r, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", width: "80px" }, { default: s((t) => [t.row.isModify && !t.row.inProductionQuantity ? (i(), u(b, { key: 0, modelValue: t.row.bendTimes, "onUpdate:modelValue": (d) => t.row.bendTimes = d, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), f("span", ut, m(t.row.bendTimes ? t.row.bendTimes : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("thickness") && a(o).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (i(), u(r, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: s((t) => [t.row.isModify && !t.row.inProductionQuantity ? (i(), u(b, { key: 0, modelValue: t.row.thickness, "onUpdate:modelValue": (d) => t.row.thickness = d, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: a(g).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (d) => Z(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (i(), f("span", st, m(t.row.thickness ? t.row.thickness.toFixed(a(g).MES_ENCLOSURE_T__MM) : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("length") ? (i(), u(r, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: s((t) => [t.row.isModify && !t.row.inProductionQuantity ? (i(), u(b, { key: 0, modelValue: t.row.length, "onUpdate:modelValue": (d) => t.row.length = d, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: a(g).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (d) => k(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (i(), f("span", ct, m(t.row.length ? t.row.length.toFixed(a(g).MES_ENCLOSURE_L__MM) : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("quantity") ? (i(), u(r, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: s((t) => [t.row.isModify && !t.row.inProductionQuantity ? (i(), u(b, { key: 0, modelValue: t.row.quantity, "onUpdate:modelValue": (d) => t.row.quantity = d, modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1, precision: a(g).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (d) => k(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (i(), f("span", mt, m(t.row.quantity), 1))]), _: 1 })) : c("", true), a(y).visible("totalArea") ? (i(), u(r, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: s((t) => [N(m(t.row.totalArea ? t.row.totalArea.toFixed(a(g).COM_AREA__M2) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("totalLength") ? (i(), u(r, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: s((t) => [N(m(t.row.totalLength ? t.row.totalLength.toFixed(a(g).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 })) : c("", true), a(o).query.category !== a(n).SANDWICH_BOARD.V ? (i(), u(r, { key: "weight", prop: "weight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: s((t) => [N(m(t.row.weight ? t.row.weight.toFixed(a(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("brand") && a(o).query.category !== a(n).SANDWICH_BOARD.V && a(o).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (i(), u(r, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: s((t) => [t.row.isModify ? (i(), u(te, { key: 0, modelValue: t.row.brand, "onUpdate:modelValue": (d) => t.row.brand = d, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), f("div", yt, m(t.row.brand ? t.row.brand : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("color") && a(o).query.category != a(n).TRUSS_FLOOR_PLATE.V && a(o).query.category != a(n).PRESSURE_BEARING_PLATE.V && a(o).query.category != a(n).SANDWICH_BOARD.V ? (i(), u(r, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "80px" }, { default: s((t) => [t.row.isModify ? (i(), u(te, { key: 0, modelValue: t.row.color, "onUpdate:modelValue": (d) => t.row.color = d, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (i(), f("div", ft, m(t.row.color ? t.row.color : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("draw") && a(o).query.category === a(n).BENDING.V ? (i(), u(r, { key: "draw", prop: "draw", "show-overflow-tooltip": true, label: "画图", "min-width": "190px" }, { default: s((t) => [h(a(tt), { "upload-fun": a(Qe), data: { id: t.row.id }, fileClassify: void 0, accept: ".jpg,.jpeg,.png", "success-msg": "上传成功", "btn-name": "上传", "btn-type": "warning", "btn-size": "default", onSuccess: pe, style: { display: "inline-block", "margin-right": "5px" } }, null, 8, ["upload-fun", "data"]), L((i(), u(S, { size: "default", type: "primary", onClick: (d) => Ve(t.row), disabled: t.row.isModify }, { default: s(() => [N(m(t.row.attachmentId ? "换图" : "画图"), 1)]), _: 2 }, 1032, ["onClick", "disabled"])), [[D, a(E).draw]]), t.row.attachmentId ? L((i(), u(S, { key: 0, size: "default", type: "primary", icon: "el-icon-view", onClick: (d) => a(H)(t.row) }, null, 8, ["onClick"])), [[D, a(E).drawDownload]]) : c("", true)]), _: 1 })) : c("", true), a(y).visible("status") ? (i(), u(r, { key: "status", prop: "status", label: "状态", align: "center", width: "70px", fixed: "right" }, { default: s((t) => [t.row.id ? (i(), u(Ne, { key: 0, modelValue: t.row.boolStatusEnum, "onUpdate:modelValue": (d) => t.row.boolStatusEnum = d, disabled: !a($)(a(E).edit), "active-color": "#13ce66", "active-value": a(I).PROCESS.V, "inactive-value": a(I).PAUSE.V, onChange: (d) => he(t.row, t.row.boolStatusEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])) : c("", true)]), _: 1 })) : c("", true), a($)([...a(E).edit, ...a(E).del]) ? (i(), u(r, { key: 17, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: s((t) => [t.row.isModify ? (i(), f(F, { key: 0 }, [h(S, { type: "info", size: "default", onClick: (d) => be(t.row) }, { default: s(() => l[3] || (l[3] = [N("取消")])), _: 2, __: [3] }, 1032, ["onClick"]), h(S, { type: "primary", size: "default", onClick: (d) => Se(t.row) }, { default: s(() => l[4] || (l[4] = [N("保存")])), _: 2, __: [4] }, 1032, ["onClick"])], 64)) : (i(), f(F, { key: 1 }, [L(h(S, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (d) => Ee(t.row) }, null, 8, ["onClick"]), [[D, a(E).edit]]), a($)(a(E).del) ? (i(), u(ke, { key: 0, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (d) => ve(t.row) }, { reference: s(() => [h(S, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : c("", true)], 64))]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[Ce, a(o).loading]]), h(a(He)), h(a(Xe)), h(a(Ze), { ref_key: "simpleDrawRef", ref: re, modelValue: q.value, "onUpdate:modelValue": l[0] || (l[0] = (t) => q.value = t), current: J.value, onToQuery: a(o).toQuery }, null, 8, ["modelValue", "current", "onToQuery"]), h(ze, { modelValue: a(O), "onUpdate:modelValue": l[1] || (l[1] = (t) => Te(O) ? O.value = t : null), "serial-number": (ae = a(Q)) == null ? void 0 : ae.serialNumber, attachmentId: (oe = a(Q)) == null ? void 0 : oe.attachmentId }, null, 8, ["modelValue", "serial-number", "attachmentId"])], 64)) : (i(), f("span", ht, "当前项目内容没有包含围护制品，请到合同管理中进行配置"))]);
  };
} }, jt = Fe(pt, [["__scopeId", "data-v-d4d2c694"]]);
export {
  jt as default
};
