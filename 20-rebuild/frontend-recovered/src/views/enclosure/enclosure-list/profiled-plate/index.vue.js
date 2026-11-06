import { ref as _ } from "vue";
import { provide as se } from "vue";
import { computed as Ae } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as H } from "vue";
import { resolveDirective as De } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as M } from "vue";
import { createElementVNode as A } from "vue";
import { createVNode as g } from "vue";
import { unref as a } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as b } from "vue";
import { isRef as Be } from "vue";
import { ElMessageBox as We } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElTableColumn as Fe } from "element-plus";
import { ElInput as Ge } from "element-plus";
import { InfoFilled as $e } from "@element-plus/icons-vue";
import { ElIcon as je } from "element-plus";
import { ElTooltip as Qe } from "element-plus";
import { ElInputNumber as He } from "element-plus";
import { ElSwitch as ze } from "element-plus";
import { vLoading as Ke } from "element-plus";
import { _ as Je, m as Ye, T as n, x as Xe, m6 as K, o as Ze, i as J, jx as et, js as tt, mk as at, D as w, ml as lt, p as ot, G as me, m8 as I, P as it, mm as rt, fK as ce, ma as nt } from "../../../../shared/runtime.js";
import { a as dt } from "../../../../modules/base-6bc46ddf.js";
import { e as V } from "../../../../modules/plan-d12d7ccf.js";
import ut from "../components/simple-drawing/index.vue.js";
import st from "../components/enclosure-change.vue.js";
import { u as mt } from "../../../../modules/use-drawing-8a7ba23b.js";
import { _ as ct } from "../../../../modules/SingleFileUploadBtn-17bec156.js";
import yt from "./module/header.vue.js";
import ht from "./module/form.vue.js";
import "../components/simple-drawing/simple-jpg.vue.js";
import "../../../../modules/change-reason-select-73e53277.js";
import "../../../../modules/area-ca564e60.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../contract/project-manage/module/enclosure-table/pressed-support-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/sandwich-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/pressed-color-table.vue.js";
import "../../../contract/project-manage/module/enclosure-table/truss-support-table.vue.js";
import "../../../plan/technical-data-manage/components/drawing-upload-btn/index.vue.js";
import "../../../../modules/index-ce9deea8.js";
const pt = { class: "app-container" }, ft = { class: "head-container" }, gt = { key: 1 }, _t = { key: 1 }, wt = { style: { display: "inline-block" } }, vt = ["onDblclick"], Et = { key: 1 }, bt = { key: 1 }, Vt = { key: 1 }, St = { key: 1 }, kt = { key: 1 }, Nt = { key: 1 }, Rt = { key: 1 }, Tt = { key: 1 }, It = { key: 1 }, Lt = { key: 1 }, Ct = { key: 1 }, Pt = { key: 1 }, Ut = { key: 1 }, Ot = { key: 1, style: { color: "red", "font-size": "13px" } }, qt = { __name: "index", setup(xt) {
  const { globalProject: Y, globalProjectId: L } = Ye(["globalProject", "globalProjectId"]), { showDrawing: B, drawingRow: X, drawingPreview: Z } = mt({}), E = _([]), v = _(true), C = _({}), ye = _(), he = { key: "id", label: "plateType", value: "id" }, pe = { key: "id", label: "serialNumber", value: "id" }, ee = _(true), P = _({});
  se("plateOption", E), se("technicalTypeStatus", v);
  const W = _(false), F = _(false), U = _({}), O = _([]), S = _({}), fe = [{ name: "压型彩板", no: n.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: n.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: n.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: n.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: n.BENDING.V, alias: "ENCLOSURE" }], ge = { add: false, edit: false, del: false, download: false }, te = _(), { crud: l, columns: y, CRUD: q } = Xe({ title: "压型彩板清单", sort: ["id.desc"], permission: { ...V }, optShow: { ...ge }, requiredQuery: ["enclosurePlanId"], invisibleColumns: ["createTime", "userName"], crudApi: { ...K }, hasPagination: true }, te), { maxHeight: _e } = Ze({ wrapperBox: ".enclosureList", paginate: true, extraHeight: 40 }), we = (t, i) => l.query.category === n.BENDING.V ? !!t : true, ve = (t, i) => l.query.category !== n.BENDING.V ? !!t : true, Ee = { serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: we, message: "展开宽度必填", trigger: "change" }], width: [{ validator: (t, i) => l.query.category !== n.BENDING.V ? !!t : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (t, i) => l.query.category !== n.TRUSS_FLOOR_PLATE.V ? !!t : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (t, i) => l.query.category === n.BENDING.V ? !!t : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (t, i) => l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V ? !!t : true, message: "请输入颜色", trigger: "blur" }] }, ae = Ae(() => {
    let t = {};
    return v.value ? t = { plateId: [{ validator: ve, message: "请选择板型", trigger: "change" }] } : t = { plate: [{ required: true, message: "请选择板型", trigger: "change" }] }, { ...Ee, ...t };
  });
  function be({ row: t, column: i }) {
    if (!t) return;
    const r = ae.value;
    let s = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[i.property] === false && (s = ce(i.property, r[i.property], t)), s && (t.verify[i.property] = true)), s ? "" : "mask-td";
  }
  Q(() => L.value, (t) => {
    t && (P.value = {}, Re(), l.query.projectId = L.value, l.toQuery());
  }, { immediate: true, deep: true }), Q(() => Y.value, (t) => {
    O.value = [], J(t) && (fe.forEach((i) => {
      t.projectContentList.findIndex((r) => Number(r.no) === i.no) > -1 && O.value.push(i);
    }), ee.value = O.value.length > 0);
  }, { deep: true, immediate: true }), Q(() => l.query, (t) => {
    x();
  }, { deep: true, immediate: true }), Ve();
  async function Ve() {
    try {
      const { technicalType: t = true } = await dt();
      v.value = t, Se();
    } catch (t) {
      console.log("获取技术交底配置状态", t), v.value = true;
    }
  }
  async function Se() {
    if (S.value = {}, !(v.value || !l.query.category || l.query.category === n.BENDING.V)) try {
      const { content: t = [] } = await et(l.query.category) || {}, i = {};
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? S.value.plate_type = t.map((r) => {
        let s = "";
        return r == null || r.list.forEach((f) => {
          f.name === "effectiveWidth" && (s = f.value);
        }), i[r.code] = { effectiveWidth: s }, { name: r.code };
      }) : t.forEach((r) => {
        r.name === "plate_type" && ((r.plateTypeList || []).forEach((s) => {
          i[s.plateType] = s;
        }), S.value[r.name] = (r.labels || []).map((s) => ({ name: s })));
      }), S.value.KV = i;
    } catch (t) {
      console.log("获取围护配置信息列表", t);
    }
  }
  async function ke(t, i) {
    try {
      const r = i === 1 ? "启用" : "暂停";
      await We.confirm("确定" + r + "?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await nt(t.id, { boolStatusEnum: !!i }), l.notify(`“${t.name}”已【${r}】`, q.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (r) {
      console.log("修改围护状态", r), t.boolStatusEnum = t.boolStatusEnum === I.PROCESS.V ? I.PAUSE.V : I.PROCESS.V;
    }
  }
  function Ne() {
    z.success("上传成功"), l.toQuery();
  }
  function le() {
    E.value = l.query.category !== n.BENDING.V ? C.value[l.query.category] : [], console.log(E.value), console.log(C.value[l.query.category]), console.log(l.query.category);
  }
  async function Re() {
    try {
      const t = await tt(L.value);
      J(t) && (C.value = { [n.PROFILED_PLATE.V]: t.profiledPlateList || [], [n.PRESSURE_BEARING_PLATE.V]: t.pressureBearingPlateList || [], [n.TRUSS_FLOOR_PLATE.V]: t.trussFloorPlateList || [], [n.SANDWICH_BOARD.V]: t.sandwichBoardList || [] }), le();
    } catch (t) {
      console.log("获取技术交底", t);
    }
  }
  function oe(t, i) {
    var r;
    if (t.plateId) {
      const s = E.value.find((f) => f.id === t.plateId);
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? (l.data[i].plate = s.serialNumber, l.data[i].weightMeter = s.weightMeter) : (l.data[i].plate = s.plateType, l.data[i].brand = s.brand, l.data[i].thickness = s.thickness, l.data[i].color = s.colour, l.data[i].unfoldedWidth = s.unfoldedWidth), l.data[i].width = s.effectiveWidth;
    } else {
      const s = ((r = S.value.KV) == null ? void 0 : r[t.plate]) || {};
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? l.data[i].width = +s.effectiveWidth : (l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V) && (l.data[i].width = +s.effectiveWidth, l.data[i].unfoldedWidth = +s.unfoldedWidth);
    }
    R(t);
  }
  function R(t) {
    t.length && t.quantity && (t.totalLength = t.length * t.quantity / 1e3, ie(t)), l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V ? t.length && t.quantity && t.unfoldedWidth && (t.totalArea = t.width * t.length * t.quantity / 1e6) : t.length && t.quantity && t.width && (t.totalArea = t.width * t.length * t.quantity / 1e6);
  }
  function ie(t) {
    l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V ? t.unfoldedWidth && t.thickness && t.totalLength && (t.totalWeight = t.unfoldedWidth / 1e3 * t.thickness * t.totalLength * 7.85) : l.query.category === n.TRUSS_FLOOR_PLATE.V && t.weightMeter && t.totalLength && (t.totalWeight = t.weightMeter * t.totalLength);
  }
  function Te() {
    if (l.query.category !== n.BENDING.V && E.value.length <= 0) {
      z.error("请先前往合同管理添加技术交底");
      return;
    }
    l.data.unshift({ id: void 0, areaId: l.query.areaId, isModify: true, dataIndex: l.data.length });
  }
  const re = _({});
  function Ie(t) {
    if (re.value = JSON.parse(JSON.stringify(t)), v.value) {
      const i = E.value.find((r) => r.plateType === t.plate);
      t.plateId = J(i) ? i.id : void 0;
    }
    t.isModify = true;
  }
  const Le = (t) => {
    U.value = t, F.value = true;
  }, Ce = async () => {
    try {
      l.toQuery();
    } catch (t) {
      console.log(t);
    }
  };
  function Pe(t) {
    if (t.id) t = Object.assign(t, JSON.parse(JSON.stringify(re.value))), t.isModify = false;
    else {
      const i = l.data.findIndex((r) => r.dataIndex === t.dataIndex);
      l.data.splice(i, 1);
    }
  }
  async function Ue(t) {
    l.query.category !== n.BENDING.V && l.data.map((f) => {
      if (!f.isModify && f.plate && v.value) {
        const G = E.value.find(($) => $.plateType === f.plate);
        f.plateId = G.id;
      }
    });
    const i = ae.value;
    let r = true;
    t.verify = {};
    for (const f in i) t.verify[f] = ce(f, i[f], t), t.verify[f] || (r = false);
    if (console.log(t), !r) {
      z.error("请填写表格中标红数据");
      return;
    }
    const s = t.id ? "修改" : "新增";
    try {
      t.id ? await K.edit(t) : await K.add(t), l.notify(`${s}成功`, q.NOTIFICATION_TYPE.SUCCESS), x(), t.isModify = false;
    } catch (f) {
      console.log(s, f);
    }
  }
  function Oe(t) {
    W.value = true, U.value = t;
  }
  q.HOOK.handleRefresh = (t, i) => (i.data.content.length > 0 && i.data.content.forEach((r) => {
    r.type = t.query.type;
  }), i);
  async function x() {
    if (l.query.enclosurePlanId && l.query.category) try {
      P.value = await at({ ...l.query });
    } catch (t) {
      console.log("获取围护汇总", t);
    }
    else P.value = {};
  }
  return q.HOOK.afterSubmit = (t, i) => {
    x();
  }, (t, i) => {
    var de, ue;
    const r = Fe, s = Ge, f = $e, G = je, $ = Qe, ne = H("common-select"), k = He, N = H("common-button"), qe = ze, xe = H("common-table"), j = De("permission"), Me = Ke;
    return o(), h("div", pt, [ee.value ? (o(), h(M, { key: 0 }, [A("div", ft, [g(a(yt), { "project-id": a(L), onTableAdd: Te, "table-data": C.value, globalProject: a(Y), typeOption: O.value, onCategoryChange: le, sumData: P.value, onSumChange: x }, null, 8, ["project-id", "table-data", "globalProject", "typeOption", "sumData"])]), D((o(), u(xe, { ref_key: "tableRef", ref: te, data: a(l).data, "empty-text": a(l).emptyText, "max-height": a(_e), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, onSortChange: a(l).handleSortChange, class: "enclosure-table", "cell-class-name": be }, { default: m(() => [g(r, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }), a(y).visible("name") ? (o(), u(r, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "120" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.name, "onUpdate:modelValue": (d) => e.row.name = d, placeholder: "名称", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", gt, p(e.row.name ? e.row.name : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("serialNumber") && a(l).query.category !== a(n).BENDING.V ? (o(), u(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.serialNumber, "onUpdate:modelValue": (d) => e.row.serialNumber = d, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", _t, p(e.row.serialNumber), 1))]), _: 1 })) : c("", true), a(y).visible("serialNumber") && a(l).query.category === a(n).BENDING.V ? (o(), u(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "90px" }, { header: m(() => [g($, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: m(() => [A("div", wt, [i[3] || (i[3] = A("span", null, "编号", -1)), g(G, null, { default: m(() => [g(f)]), _: 1 })])]), _: 1 })]), default: m((e) => [A("span", { style: { cursor: "pointer" }, onDblclick: (d) => a(Z)(e.row) }, p(e.row.serialNumber), 41, vt)]), _: 1 })) : c("", true), a(y).visible("plateId") && a(l).query.category !== a(n).BENDING.V ? (o(), u(r, { key: v.value ? "plateId" : "plate", prop: v.value ? "plateId" : "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: m((e) => {
      var d;
      return [e.row.isModify && !e.row.inProductionQuantity ? (o(), h(M, { key: 0 }, [v.value ? (o(), u(ne, { key: 0, modelValue: e.row.plateId, "onUpdate:modelValue": (T) => e.row.plateId = T, options: E.value, type: "other", dataStructure: a(l).query.category === a(n).TRUSS_FLOOR_PLATE.V ? pe : he, size: "default", placeholder: "板型", onChange: (T) => oe(e.row, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (o(), u(ne, { key: 1, modelValue: e.row.plate, "onUpdate:modelValue": (T) => e.row.plate = T, options: (d = S.value) == null ? void 0 : d.plate_type, dataStructure: { key: "name", label: "name", value: "name" }, size: "default", placeholder: "板型", onChange: (T) => oe(e.row, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))], 64)) : (o(), h("div", Et, p(e.row.plate ? e.row.plate : "-"), 1))];
    }), _: 1 }, 8, ["prop"])) : c("", true), a(y).visible("width") && a(l).query.category !== a(n).BENDING.V ? (o(), u(r, { key: "width", prop: "width", "show-overflow-tooltip": true, label: a(l).query.category === a(n).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: m((e) => [e.row.isModify && a(l).query.category !== a(n).PROFILED_PLATE.V && a(l).query.category !== a(n).PRESSURE_BEARING_PLATE.V && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.width, "onUpdate:modelValue": (d) => e.row.width = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), h("div", bt, p(e.row.width ? e.row.width.toFixed(a(w).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : c("", true), a(y).visible("unfoldedWidth") && (a(l).query.category === a(n).BENDING.V || a(l).query.category === a(n).PROFILED_PLATE.V || a(l).query.category === a(n).PRESSURE_BEARING_PLATE.V) ? (o(), u(r, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity && a(l).query.category === a(n).BENDING.V ? (o(), u(k, { key: 0, modelValue: e.row.unfoldedWidth, "onUpdate:modelValue": (d) => e.row.unfoldedWidth = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), h("div", Vt, p(e.row.unfoldedWidth ? e.row.unfoldedWidth.toFixed(a(w).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : c("", true), a(l).query.category === a(n).BENDING.V ? (o(), u(r, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", width: "80px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.bendTimes, "onUpdate:modelValue": (d) => e.row.bendTimes = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("span", St, p(e.row.bendTimes ? e.row.bendTimes : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("thickness") && a(l).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (o(), u(r, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.thickness, "onUpdate:modelValue": (d) => e.row.thickness = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (d) => ie(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), h("span", kt, p(e.row.thickness ? e.row.thickness.toFixed(a(w).MES_ENCLOSURE_T__MM) : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("length") ? (o(), u(r, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.length, "onUpdate:modelValue": (d) => e.row.length = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), h("span", Nt, p(e.row.length ? e.row.length.toFixed(a(w).MES_ENCLOSURE_L__MM) : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("quantity") ? (o(), u(r, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.quantity, "onUpdate:modelValue": (d) => e.row.quantity = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), h("span", Rt, p(e.row.quantity), 1))]), _: 1 })) : c("", true), a(y).visible("totalArea") ? (o(), u(r, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: m((e) => [b(p(e.row.totalArea ? e.row.totalArea.toFixed(a(w).COM_ENCLOSURE_AREA__M2) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("totalLength") ? (o(), u(r, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: m((e) => [b(p(e.row.totalLength ? e.row.totalLength.toFixed(a(w).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 })) : c("", true), a(l).query.category !== a(n).SANDWICH_BOARD.V ? (o(), u(r, { key: "totalWeight", prop: "totalWeight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: m((e) => [b(p(e.row.totalWeight ? e.row.totalWeight.toFixed(a(w).COM_WT__KG) : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("material") ? (o(), u(r, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "100px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.material, "onUpdate:modelValue": (d) => e.row.material = d, placeholder: "材质", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", Tt, p(e.row.material ? e.row.material : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("coating") ? (o(), u(r, { key: "coating", prop: "coating", "show-overflow-tooltip": true, label: "涂层", "min-width": "100px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.coating, "onUpdate:modelValue": (d) => e.row.coating = d, placeholder: "涂层", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", It, p(e.row.coating ? e.row.coating : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("plating") ? (o(), u(r, { key: "plating", prop: "plating", "show-overflow-tooltip": true, label: "镀层", "min-width": "100px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.plating, "onUpdate:modelValue": (d) => e.row.plating = d, placeholder: "镀层", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", Lt, p(e.row.plating ? e.row.plating : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("brand") && a(l).query.category !== a(n).SANDWICH_BOARD.V && a(l).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (o(), u(r, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.brand, "onUpdate:modelValue": (d) => e.row.brand = d, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", Ct, p(e.row.brand ? e.row.brand : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("color") && a(l).query.category != a(n).TRUSS_FLOOR_PLATE.V && a(l).query.category != a(n).PRESSURE_BEARING_PLATE.V && a(l).query.category != a(n).SANDWICH_BOARD.V ? (o(), u(r, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "80px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.color, "onUpdate:modelValue": (d) => e.row.color = d, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", Pt, p(e.row.color ? e.row.color : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("remark") ? (o(), u(r, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (d) => e.row.remark = d, placeholder: "备注", type: "textarea", maxlength: "200", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), h("div", Ut, p(e.row.remark ? e.row.remark : "-"), 1))]), _: 1 })) : c("", true), a(y).visible("draw") && a(l).query.category === a(n).BENDING.V ? (o(), u(r, { key: "draw", prop: "draw", "show-overflow-tooltip": true, label: "画图", "min-width": "190px" }, { default: m((e) => [g(a(ct), { "upload-fun": a(lt), data: { id: e.row.id }, fileClassify: void 0, accept: ".jpg,.jpeg,.png", "success-msg": "上传成功", "btn-name": "上传", "btn-type": "warning", "btn-size": "default", onSuccess: Ne, style: { display: "inline-block", "margin-right": "5px" } }, null, 8, ["upload-fun", "data"]), D((o(), u(N, { size: "default", type: "primary", onClick: (d) => Oe(e.row), disabled: e.row.isModify }, { default: m(() => [b(p(e.row.attachmentId ? "换图" : "画图"), 1)]), _: 2 }, 1032, ["onClick", "disabled"])), [[j, a(V).draw]]), e.row.attachmentId ? D((o(), u(N, { key: 0, size: "default", type: "primary", icon: "el-icon-view", onClick: (d) => a(Z)(e.row) }, null, 8, ["onClick"])), [[j, a(V).drawDownload]]) : c("", true)]), _: 1 })) : c("", true), a(y).visible("createTime") ? (o(), u(r, { key: "createTime", prop: "createTime", label: "上传时间", align: "center", "show-overflow-tooltip": "", width: "110" }, { default: m((e) => [b(p(e.row.createTime ? a(ot)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : c("", true), a(y).visible("userName") ? (o(), u(r, { key: "userName", prop: "userName", label: "上传人", align: "center", "show-overflow-tooltip": "", width: "100" })) : c("", true), a(y).visible("status") ? (o(), u(r, { key: "status", prop: "status", label: "状态", align: "center", width: "70px", fixed: "right" }, { default: m((e) => [e.row.id ? (o(), u(qe, { key: 0, modelValue: e.row.boolStatusEnum, "onUpdate:modelValue": (d) => e.row.boolStatusEnum = d, disabled: !a(me)(a(V).edit), "active-color": "#13ce66", "active-value": a(I).PROCESS.V, "inactive-value": a(I).PAUSE.V, onChange: (d) => ke(e.row, e.row.boolStatusEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])) : c("", true)]), _: 1 })) : c("", true), a(me)([...a(V).edit, ...a(V).del]) ? (o(), u(r, { key: 23, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: m((e) => [e.row.isModify ? (o(), h(M, { key: 0 }, [g(N, { type: "info", size: "default", onClick: (d) => Pe(e.row) }, { default: m(() => i[4] || (i[4] = [b("取消")])), _: 2, __: [4] }, 1032, ["onClick"]), g(N, { type: "primary", size: "default", onClick: (d) => Ue(e.row) }, { default: m(() => i[5] || (i[5] = [b("保存")])), _: 2, __: [5] }, 1032, ["onClick"])], 64)) : (o(), h(M, { key: 1 }, [D(g(N, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (d) => Ie(e.row) }, null, 8, ["onClick"]), [[j, a(V).edit]]), g(N, { size: "default", icon: "el-icon-view", type: "success", onClick: (d) => Le(e.row) }, null, 8, ["onClick"])], 64))]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[Me, a(l).loading]]), g(a(it)), g(a(ht)), g(a(ut), { ref_key: "simpleDrawRef", ref: ye, modelValue: W.value, "onUpdate:modelValue": i[0] || (i[0] = (e) => W.value = e), current: U.value, onToQuery: a(l).toQuery }, null, 8, ["modelValue", "current", "onToQuery"]), g(rt, { modelValue: a(B), "onUpdate:modelValue": i[1] || (i[1] = (e) => Be(B) ? B.value = e : null), "serial-number": (de = a(X)) == null ? void 0 : de.serialNumber, attachmentId: (ue = a(X)) == null ? void 0 : ue.attachmentId }, null, 8, ["modelValue", "serial-number", "attachmentId"]), g(st, { visible: F.value, "onUpdate:visible": i[2] || (i[2] = (e) => F.value = e), detailInfo: U.value, onSuccess: Ce }, null, 8, ["visible", "detailInfo"])], 64)) : (o(), h("span", Ot, "当前项目内容没有包含围护制品，请到合同管理中进行配置"))]);
  };
} }, ma = Je(qt, [["__scopeId", "data-v-c72972fa"]]);
export {
  ma as default
};
