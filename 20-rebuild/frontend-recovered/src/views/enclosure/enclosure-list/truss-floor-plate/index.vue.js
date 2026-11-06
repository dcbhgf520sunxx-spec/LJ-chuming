import { ref as _ } from "vue";
import { provide as se } from "vue";
import { computed as xe } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as Ae } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as A } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as g } from "vue";
import { unref as a } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as d } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as V } from "vue";
import { isRef as De } from "vue";
import { ElMessageBox as Be } from "element-plus";
import { ElMessage as H } from "element-plus";
import { ElTableColumn as We } from "element-plus";
import { ElInput as Fe } from "element-plus";
import { InfoFilled as Ge } from "@element-plus/icons-vue";
import { ElIcon as $e } from "element-plus";
import { ElTooltip as je } from "element-plus";
import { ElInputNumber as Qe } from "element-plus";
import { ElSwitch as ze } from "element-plus";
import { vLoading as He } from "element-plus";
import { _ as Ke, m as Je, T as n, x as Ye, m6 as K, o as Xe, i as J, jx as Ze, js as et, mk as tt, D as w, ml as at, p as lt, G as me, m8 as I, P as ot, mm as it, fK as ce, ma as rt } from "../../../../shared/runtime.js";
import { a as nt } from "../../../../modules/base-6bc46ddf.js";
import { e as S } from "../../../../modules/plan-d12d7ccf.js";
import ut from "../components/enclosure-change.vue.js";
import dt from "../components/simple-drawing/index.vue.js";
import { u as st } from "../../../../modules/use-drawing-8a7ba23b.js";
import { _ as mt } from "../../../../modules/SingleFileUploadBtn-17bec156.js";
import ct from "./module/header.vue.js";
import yt from "./module/form.vue.js";
import "../../../../modules/change-reason-select-73e53277.js";
import "../components/simple-drawing/simple-jpg.vue.js";
import "../../../../modules/area-ca564e60.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../contract/project-manage/module/enclosure-table/pressed-support-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/sandwich-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/pressed-color-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/truss-support-table.vue.js";
import "../../../plan/technical-data-manage/components/drawing-upload-btn/index.vue.js";
import "../../../../modules/index-ce9deea8.js";
const ht = { class: "app-container" }, ft = { class: "head-container" }, pt = { key: 1 }, gt = { key: 1 }, _t = { style: { display: "inline-block" } }, wt = ["onDblclick"], vt = { key: 1 }, Et = { key: 1 }, bt = { key: 1 }, Vt = { key: 1 }, St = { key: 1 }, kt = { key: 1 }, Nt = { key: 1 }, Tt = { key: 1 }, Rt = { key: 1 }, Lt = { key: 1 }, Ct = { key: 1, style: { color: "red", "font-size": "13px" } }, It = { __name: "index", setup(Pt) {
  const { globalProject: Y, globalProjectId: P } = Je(["globalProject", "globalProjectId"]), { showDrawing: W, drawingRow: X, drawingPreview: Z } = st({}), E = _([]), v = _(true), F = _({}), G = _(false), ye = _(), he = { key: "id", label: "plateType", value: "id" }, fe = { key: "id", label: "serialNumber", value: "id" }, ee = _(true), M = _({});
  se("plateOption", E), se("technicalTypeStatus", v);
  const $ = _(false), O = _({}), q = _([]), k = _({}), pe = [{ name: "压型彩板", no: n.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: n.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: n.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: n.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: n.BENDING.V, alias: "ENCLOSURE" }], ge = { add: false, edit: false, del: false, download: false }, te = _(), { crud: l, columns: y, CRUD: U } = Ye({ title: "桁架楼承板清单", sort: ["id.desc"], permission: { ...S }, optShow: { ...ge }, requiredQuery: ["enclosurePlanId"], invisibleColumns: ["createTime", "userName"], crudApi: { ...K }, hasPagination: true }, te), { maxHeight: _e } = Xe({ wrapperBox: ".enclosureList", paginate: true, extraHeight: 40 }), we = (t, o) => l.query.category === n.BENDING.V ? !!t : true, ve = (t, o) => l.query.category !== n.BENDING.V ? !!t : true, Ee = { serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: we, message: "展开宽度必填", trigger: "change" }], width: [{ validator: (t, o) => l.query.category !== n.BENDING.V ? !!t : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (t, o) => l.query.category !== n.TRUSS_FLOOR_PLATE.V ? !!t : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (t, o) => l.query.category === n.BENDING.V ? !!t : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (t, o) => l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V ? !!t : true, message: "请输入颜色", trigger: "blur" }] }, ae = xe(() => {
    let t = {};
    return v.value ? t = { plateId: [{ validator: ve, message: "请选择板型", trigger: "change" }] } : t = { plate: [{ required: true, message: "请选择板型", trigger: "change" }] }, { ...Ee, ...t };
  });
  function be({ row: t, column: o }) {
    if (!t) return;
    const i = ae.value;
    let s = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[o.property] === false && (s = ce(o.property, i[o.property], t)), s && (t.verify[o.property] = true)), s ? "" : "mask-td";
  }
  Q(() => P.value, (t) => {
    t && (M.value = {}, Te(), l.query.projectId = P.value, l.toQuery());
  }, { immediate: true, deep: true }), Q(() => Y.value, (t) => {
    q.value = [], J(t) && (pe.forEach((o) => {
      t.projectContentList.findIndex((i) => Number(i.no) === o.no) > -1 && q.value.push(o);
    }), ee.value = q.value.length > 0);
  }, { deep: true, immediate: true }), Q(() => l.query, (t) => {
    x();
  }, { deep: true, immediate: true }), Ve();
  async function Ve() {
    try {
      const { technicalType: t = true } = await nt();
      v.value = t, Se();
    } catch (t) {
      console.log("获取技术交底配置状态", t), v.value = true;
    }
  }
  async function Se() {
    if (k.value = {}, !(v.value || !l.query.category || l.query.category === n.BENDING.V)) try {
      const { content: t = [] } = await Ze(l.query.category) || {}, o = {};
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? k.value.plate_type = t.map((i) => {
        let s = "", p = "";
        return i == null || i.list.forEach((b) => {
          b.name === "effectiveWidth" && (s = b.value), b.name === "weightMeter" && (p = b.value);
        }), o[i.code] = { effectiveWidth: s, weightMeter: p }, { name: i.code };
      }) : t.forEach((i) => {
        i.name === "plate_type" && ((i.plateTypeList || []).forEach((s) => {
          o[s.plateType] = s;
        }), k.value[i.name] = (i.labels || []).map((s) => ({ name: s })));
      }), k.value.KV = o;
    } catch (t) {
      console.log("获取围护配置信息列表", t);
    }
  }
  async function ke(t, o) {
    try {
      const i = o === 1 ? "启用" : "暂停";
      await Be.confirm("确定" + i + "?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await rt(t.id, { boolStatusEnum: !!o }), l.notify(`“${t.name}”已【${i}】`, U.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (i) {
      console.log("修改围护状态", i), t.boolStatusEnum = t.boolStatusEnum === I.PROCESS.V ? I.PAUSE.V : I.PROCESS.V;
    }
  }
  function Ne() {
    H.success("上传成功"), l.toQuery();
  }
  function le() {
    E.value = l.query.category !== n.BENDING.V ? F.value[l.query.category] : [];
  }
  async function Te() {
    try {
      const t = await et(P.value);
      J(t) && (F.value = { [n.PROFILED_PLATE.V]: t.profiledPlateList || [], [n.PRESSURE_BEARING_PLATE.V]: t.pressureBearingPlateList || [], [n.TRUSS_FLOOR_PLATE.V]: t.trussFloorPlateList || [], [n.SANDWICH_BOARD.V]: t.sandwichBoardList || [] }), le();
    } catch (t) {
      console.log("获取技术交底", t);
    }
  }
  function oe(t, o) {
    var i;
    if (t.plateId) {
      const s = E.value.find((p) => p.id === t.plateId);
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? (l.data[o].plate = s.serialNumber, l.data[o].weightMeter = s.weightMeter) : (l.data[o].plate = s.plateType, l.data[o].brand = s.brand, l.data[o].thickness = s.thickness, l.data[o].color = s.colour, l.data[o].unfoldedWidth = s.unfoldedWidth), l.data[o].width = s.effectiveWidth;
    } else {
      const s = ((i = k.value.KV) == null ? void 0 : i[t.plate]) || {};
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? (l.data[o].width = +s.effectiveWidth, l.data[o].weightMeter = +s.weightMeter) : (l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V) && (l.data[o].width = +s.effectiveWidth, l.data[o].unfoldedWidth = +s.unfoldedWidth);
    }
    R(t);
  }
  function R(t) {
    t.length && t.quantity && (t.totalLength = t.length * t.quantity / 1e3, ie(t)), l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V ? t.length && t.quantity && t.unfoldedWidth && (t.totalArea = t.unfoldedWidth * t.length * t.quantity / 1e6) : t.length && t.quantity && t.width && (t.totalArea = t.width * t.length * t.quantity / 1e6);
  }
  function ie(t) {
    l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V ? t.unfoldedWidth && t.thickness && t.totalLength && (t.totalWeight = t.unfoldedWidth / 1e3 * t.thickness * t.totalLength * 7.85) : l.query.category === n.TRUSS_FLOOR_PLATE.V && t.weightMeter && t.totalLength && (t.totalWeight = t.weightMeter * t.totalLength);
  }
  function Re() {
    if (l.query.category !== n.BENDING.V && E.value.length <= 0) {
      H.error("请先前往合同管理添加技术交底");
      return;
    }
    l.data.unshift({ id: void 0, areaId: l.query.areaId, isModify: true, dataIndex: l.data.length });
  }
  const re = _({});
  function Le(t) {
    if (re.value = JSON.parse(JSON.stringify(t)), v.value) {
      const o = l.query.category !== n.TRUSS_FLOOR_PLATE.V ? E.value.find((i) => i.plateType === t.plate) : E.value.find((i) => i.serialNumber === t.plate);
      t.plateId = J(o) ? o.id : void 0;
    }
    t.isModify = true;
  }
  const Ce = (t) => {
    O.value = t, G.value = true;
  };
  function Ie(t) {
    if (t.id) t = Object.assign(t, JSON.parse(JSON.stringify(re.value))), t.isModify = false;
    else {
      const o = l.data.findIndex((i) => i.dataIndex === t.dataIndex);
      l.data.splice(o, 1);
    }
  }
  async function Pe(t) {
    l.query.category !== n.BENDING.V && l.data.map((p) => {
      if (!p.isModify && p.plate && v.value) {
        const b = l.query.category !== n.TRUSS_FLOOR_PLATE.V ? E.value.find((L) => L.plateType === t.plate) : E.value.find((L) => L.serialNumber === t.plate);
        p.plateId = b.id;
      }
    });
    const o = ae.value;
    let i = true;
    t.verify = {};
    for (const p in o) t.verify[p] = ce(p, o[p], t), t.verify[p] || (i = false);
    if (console.log(t), !i) {
      H.error("请填写表格中标红数据");
      return;
    }
    const s = t.id ? "修改" : "新增";
    try {
      t.id ? await K.edit(t) : await K.add(t), x(), l.notify(`${s}成功`, U.NOTIFICATION_TYPE.SUCCESS), t.isModify = false;
    } catch (p) {
      console.log(s, p);
    }
  }
  function Me(t) {
    $.value = true, O.value = t;
  }
  U.HOOK.handleRefresh = (t, o) => (o.data.content.length > 0 && o.data.content.forEach((i) => {
    i.type = t.query.type;
  }), o);
  async function x() {
    if (l.query.enclosurePlanId && l.query.category) try {
      M.value = await tt({ ...l.query });
    } catch (t) {
      console.log("获取围护汇总", t);
    }
    else M.value = {};
  }
  return U.HOOK.afterSubmit = (t, o) => {
    x();
  }, (t, o) => {
    var ue, de;
    const i = We, s = Fe, p = Ge, b = $e, L = je, ne = z("common-select"), N = Qe, T = z("common-button"), Oe = ze, qe = z("common-table"), j = Ae("permission"), Ue = He;
    return r(), f("div", ht, [ee.value ? (r(), f(A, { key: 0 }, [D("div", ft, [g(a(ct), { "project-id": a(P), onTableAdd: Re, "table-data": F.value, globalProject: a(Y), typeOption: q.value, onCategoryChange: le, sumData: M.value, onSumChange: x }, null, 8, ["project-id", "table-data", "globalProject", "typeOption", "sumData"])]), B((r(), d(qe, { ref_key: "tableRef", ref: te, data: a(l).data, "empty-text": a(l).emptyText, "max-height": a(_e), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, onSortChange: a(l).handleSortChange, class: "enclosure-table", "cell-class-name": be }, { default: m(() => [g(i, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }), a(y).visible("name") ? (r(), d(i, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "120" }, { default: m((e) => [e.row.isModify ? (r(), d(s, { key: 0, modelValue: e.row.name, "onUpdate:modelValue": (u) => e.row.name = u, placeholder: "名称", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", pt, h(e.row.name ? e.row.name : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("serialNumber") && a(l).query.category !== a(n).BENDING.V ? (r(), d(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120px" }, { default: m((e) => [e.row.isModify ? (r(), d(s, { key: 0, modelValue: e.row.serialNumber, "onUpdate:modelValue": (u) => e.row.serialNumber = u, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", gt, h(e.row.serialNumber), 1))]), _: 1 })) : c("", true), a(y).visible("serialNumber") && a(l).query.category === a(n).BENDING.V ? (r(), d(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { header: m(() => [g(L, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: m(() => [D("div", _t, [o[3] || (o[3] = D("span", null, "编号", -1)), g(b, null, { default: m(() => [g(p)]), _: 1 })])]), _: 1 })]), default: m((e) => [D("span", { style: { cursor: "pointer" }, onDblclick: (u) => a(Z)(e.row) }, h(e.row.serialNumber), 41, wt)]), _: 1 })) : c("", true), a(y).visible("plateId") && a(l).query.category !== a(n).BENDING.V ? (r(), d(i, { key: v.value ? "plateId" : "plate", prop: v.value ? "plateId" : "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: m((e) => {
      var u;
      return [e.row.isModify && !e.row.inProductionQuantity ? (r(), f(A, { key: 0 }, [v.value ? (r(), d(ne, { key: 0, modelValue: e.row.plateId, "onUpdate:modelValue": (C) => e.row.plateId = C, options: E.value, type: "other", dataStructure: a(l).query.category === a(n).TRUSS_FLOOR_PLATE.V ? fe : he, size: "default", placeholder: "板型", onChange: (C) => oe(e.row, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (r(), d(ne, { key: 1, modelValue: e.row.plate, "onUpdate:modelValue": (C) => e.row.plate = C, options: (u = k.value) == null ? void 0 : u.plate_type, dataStructure: { key: "name", label: "name", value: "name" }, size: "default", placeholder: "板型", onChange: (C) => oe(e.row, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))], 64)) : (r(), f("div", vt, h(e.row.plate ? e.row.plate : "-"), 1))];
    }), _: 1 }, 8, ["prop"])) : c("", true), a(y).visible("weightMeter") ? (r(), d(i, { key: "weightMeter", prop: "weightMeter", label: "米重(kg/m)", align: "left", width: "100px" }, { default: m((e) => [V(h(e.row.weightMeter ? e.row.weightMeter.toFixed(a(w).COM_WT__KG) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("width") && a(l).query.category !== a(n).BENDING.V ? (r(), d(i, { key: "width", prop: "width", "show-overflow-tooltip": true, label: a(l).query.category === a(n).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: m((e) => [e.row.isModify && a(l).query.category !== a(n).PROFILED_PLATE.V && a(l).query.category !== a(n).PRESSURE_BEARING_PLATE.V && !e.row.inProductionQuantity ? (r(), d(N, { key: 0, modelValue: e.row.width, "onUpdate:modelValue": (u) => e.row.width = u, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (u) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (r(), f("div", Et, h(e.row.width ? e.row.width.toFixed(a(w).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : c("", true), a(y).visible("unfoldedWidth") && (a(l).query.category === a(n).BENDING.V || a(l).query.category === a(n).PROFILED_PLATE.V || a(l).query.category === a(n).PRESSURE_BEARING_PLATE.V) ? (r(), d(i, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity && a(l).query.category === a(n).BENDING.V ? (r(), d(N, { key: 0, modelValue: e.row.unfoldedWidth, "onUpdate:modelValue": (u) => e.row.unfoldedWidth = u, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (u) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (r(), f("div", bt, h(e.row.unfoldedWidth ? e.row.unfoldedWidth.toFixed(a(w).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : c("", true), a(l).query.category === a(n).BENDING.V ? (r(), d(i, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", width: "80px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (r(), d(N, { key: 0, modelValue: e.row.bendTimes, "onUpdate:modelValue": (u) => e.row.bendTimes = u, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("span", Vt, h(e.row.bendTimes ? e.row.bendTimes : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("thickness") && a(l).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (r(), d(i, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (r(), d(N, { key: 0, modelValue: e.row.thickness, "onUpdate:modelValue": (u) => e.row.thickness = u, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (u) => ie(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (r(), f("span", St, h(e.row.thickness ? e.row.thickness.toFixed(a(w).MES_ENCLOSURE_T__MM) : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("length") ? (r(), d(i, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (r(), d(N, { key: 0, modelValue: e.row.length, "onUpdate:modelValue": (u) => e.row.length = u, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (u) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (r(), f("span", kt, h(e.row.length ? e.row.length.toFixed(a(w).MES_ENCLOSURE_L__MM) : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("quantity") ? (r(), d(i, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (r(), d(N, { key: 0, modelValue: e.row.quantity, "onUpdate:modelValue": (u) => e.row.quantity = u, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (u) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (r(), f("span", Nt, h(e.row.quantity), 1))]), _: 1 })) : c("", true), a(y).visible("totalArea") ? (r(), d(i, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: m((e) => [V(h(e.row.totalArea ? e.row.totalArea.toFixed(a(w).COM_ENCLOSURE_AREA__M2) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("totalLength") ? (r(), d(i, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: m((e) => [V(h(e.row.totalLength ? e.row.totalLength.toFixed(a(w).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 })) : c("", true), a(l).query.category !== a(n).SANDWICH_BOARD.V ? (r(), d(i, { key: "totalWeight", prop: "totalWeight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: m((e) => [V(h(e.row.totalWeight ? e.row.totalWeight.toFixed(a(w).COM_WT__KG) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("brand") ? (r(), d(i, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: m((e) => [e.row.isModify ? (r(), d(s, { key: 0, modelValue: e.row.brand, "onUpdate:modelValue": (u) => e.row.brand = u, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", Tt, h(e.row.brand ? e.row.brand : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("color") ? (r(), d(i, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "80px" }, { default: m((e) => [e.row.isModify ? (r(), d(s, { key: 0, modelValue: e.row.color, "onUpdate:modelValue": (u) => e.row.color = u, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", Rt, h(e.row.color ? e.row.color : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("remark") ? (r(), d(i, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: m((e) => [e.row.isModify ? (r(), d(s, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (u) => e.row.remark = u, placeholder: "备注", type: "textarea", maxlength: "200", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), f("div", Lt, h(e.row.remark ? e.row.remark : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("draw") && a(l).query.category === a(n).BENDING.V ? (r(), d(i, { key: "draw", prop: "draw", "show-overflow-tooltip": true, label: "画图", "min-width": "190px" }, { default: m((e) => [g(a(mt), { "upload-fun": a(at), data: { id: e.row.id }, fileClassify: void 0, accept: ".jpg,.jpeg,.png", "success-msg": "上传成功", "btn-name": "上传", "btn-type": "warning", "btn-size": "default", onSuccess: Ne, style: { display: "inline-block", "margin-right": "5px" } }, null, 8, ["upload-fun", "data"]), B((r(), d(T, { size: "default", type: "primary", onClick: (u) => Me(e.row), disabled: e.row.isModify }, { default: m(() => [V(h(e.row.attachmentId ? "换图" : "画图"), 1)]), _: 2 }, 1032, ["onClick", "disabled"])), [[j, a(S).draw]]), e.row.attachmentId ? B((r(), d(T, { key: 0, size: "default", type: "primary", icon: "el-icon-view", onClick: (u) => a(Z)(e.row) }, null, 8, ["onClick"])), [[j, a(S).drawDownload]]) : c("", true)]), _: 1 })) : c("", true), a(y).visible("createTime") ? (r(), d(i, { key: "createTime", prop: "createTime", label: "上传时间", align: "center", "show-overflow-tooltip": "", width: "110" }, { default: m((e) => [V(h(e.row.createTime ? a(lt)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("userName") ? (r(), d(i, { key: "userName", prop: "userName", label: "上传人", align: "center", "show-overflow-tooltip": "", width: "100" })) : c("", true), a(y).visible("status") ? (r(), d(i, { key: "status", prop: "status", label: "状态", align: "center", width: "70px", fixed: "right" }, { default: m((e) => [e.row.id ? (r(), d(Oe, { key: 0, modelValue: e.row.boolStatusEnum, "onUpdate:modelValue": (u) => e.row.boolStatusEnum = u, disabled: !a(me)(a(S).edit), "active-color": "#13ce66", "active-value": a(I).PROCESS.V, "inactive-value": a(I).PAUSE.V, onChange: (u) => ke(e.row, e.row.boolStatusEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])) : c("", true)]), _: 1 })) : c("", true), a(me)([...a(S).edit, ...a(S).del]) ? (r(), d(i, { key: 21, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: m((e) => [e.row.isModify ? (r(), f(A, { key: 0 }, [g(T, { type: "info", size: "default", onClick: (u) => Ie(e.row) }, { default: m(() => o[4] || (o[4] = [V("取消")])), _: 2, __: [4] }, 1032, ["onClick"]), g(T, { type: "primary", size: "default", onClick: (u) => Pe(e.row) }, { default: m(() => o[5] || (o[5] = [V("保存")])), _: 2, __: [5] }, 1032, ["onClick"])], 64)) : (r(), f(A, { key: 1 }, [B(g(T, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (u) => Le(e.row) }, null, 8, ["onClick"]), [[j, a(S).edit]]), g(T, { size: "default", icon: "el-icon-view", type: "success", onClick: (u) => Ce(e.row) }, null, 8, ["onClick"])], 64))]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[Ue, a(l).loading]]), g(a(ot)), g(a(yt)), g(a(dt), { ref_key: "simpleDrawRef", ref: ye, modelValue: $.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => $.value = e), current: O.value, onToQuery: a(l).toQuery }, null, 8, ["modelValue", "current", "onToQuery"]), g(it, { modelValue: a(W), "onUpdate:modelValue": o[1] || (o[1] = (e) => De(W) ? W.value = e : null), "serial-number": (ue = a(X)) == null ? void 0 : ue.serialNumber, attachmentId: (de = a(X)) == null ? void 0 : de.attachmentId }, null, 8, ["modelValue", "serial-number", "attachmentId"]), g(ut, { visible: G.value, "onUpdate:visible": o[2] || (o[2] = (e) => G.value = e), detailInfo: O.value }, null, 8, ["visible", "detailInfo"])], 64)) : (r(), f("span", Ct, "当前项目内容没有包含围护制品，请到合同管理中进行配置"))]);
  };
} }, na = Ke(It, [["__scopeId", "data-v-e26161e2"]]);
export {
  na as default
};
