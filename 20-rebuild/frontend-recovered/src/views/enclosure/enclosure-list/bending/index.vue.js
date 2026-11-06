import { ref as _ } from "vue";
import { provide as me } from "vue";
import { computed as Ae } from "vue";
import { watch as j } from "vue";
import { resolveComponent as Q } from "vue";
import { resolveDirective as De } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as M } from "vue";
import { createElementVNode as H } from "vue";
import { createVNode as g } from "vue";
import { unref as a } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as f } from "vue";
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
import { _ as Je, m as Ye, T as n, x as Xe, m6 as K, o as Ze, i as J, jx as et, js as tt, mk as at, D as w, ml as lt, p as ot, G as ce, m8 as I, P as it, mm as rt, fK as ye, ma as nt } from "../../../../shared/runtime.js";
import { a as dt } from "../../../../modules/base-6bc46ddf.js";
import { e as V } from "../../../../modules/plan-d12d7ccf.js";
import ut from "../components/enclosure-change.vue.js";
import st from "../components/simple-drawing/index.vue.js";
import { u as mt } from "../../../../modules/use-drawing-8a7ba23b.js";
import { _ as ct } from "../../../../modules/SingleFileUploadBtn-17bec156.js";
import yt from "./module/header.vue.js";
import ht from "./module/form.vue.js";
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
const ft = { class: "app-container" }, pt = { class: "head-container" }, gt = { key: 1 }, _t = { key: 1 }, wt = { style: { display: "inline-block" } }, vt = ["onDblclick"], Et = { key: 1 }, bt = { key: 1 }, Vt = { key: 1 }, St = { key: 1 }, kt = { key: 1 }, Nt = { key: 1 }, Rt = { key: 1 }, Tt = { key: 1 }, It = { key: 1 }, Ct = { key: 1 }, Lt = { key: 1 }, Pt = { key: 1 }, Ut = { key: 1, style: { color: "red", "font-size": "13px" } }, Ot = { __name: "index", setup(qt) {
  const { globalProject: Y, globalProjectId: C } = Ye(["globalProject", "globalProjectId"]), { showDrawing: A, drawingRow: X, drawingPreview: Z } = mt({}), E = _([]), v = _(true), D = _({}), he = _(), fe = { key: "id", label: "plateType", value: "id" }, pe = { key: "id", label: "serialNumber", value: "id" }, ee = _(true), B = _(false), L = _({});
  me("plateOption", E), me("technicalTypeStatus", v);
  const W = _(false), P = _({}), U = _([]), S = _({}), ge = [{ name: "压型彩板", no: n.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: n.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: n.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: n.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: n.BENDING.V, alias: "ENCLOSURE" }], _e = { add: false, edit: false, del: false, download: false }, te = _(), { crud: l, columns: h, CRUD: O } = Xe({ title: "折边件清单", sort: ["id.desc"], permission: { ...V }, optShow: { ..._e }, requiredQuery: ["enclosurePlanId"], invisibleColumns: ["createTime", "userName"], crudApi: { ...K }, hasPagination: true }, te), { maxHeight: we } = Ze({ wrapperBox: ".enclosureList", paginate: true, extraHeight: 40 }), ve = (t, i) => l.query.category === n.BENDING.V ? !!t : true, ae = (t, i) => l.query.category !== n.BENDING.V ? !!t : true, Ee = { serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], unfoldedWidth: [{ validator: ve, message: "展开宽度必填", trigger: "change" }], width: [{ validator: (t, i) => l.query.category !== n.BENDING.V ? !!t : true, message: "有效宽度必填", trigger: "change" }], thickness: [{ validator: (t, i) => l.query.category !== n.TRUSS_FLOOR_PLATE.V ? !!t : true, message: "厚度必填", trigger: "change" }], length: [{ required: true, message: "单长必填", trigger: "change" }], quantity: [{ required: true, message: "数量必填", trigger: "change" }], totalArea: [{ required: true, message: "总面积必填", trigger: "change" }], totalLength: [{ required: true, message: "总长度必填", trigger: "change" }], bendTimes: [{ validator: (t, i) => l.query.category === n.BENDING.V ? !!t : true, message: "折弯次数必填", trigger: "change" }], color: [{ validator: (t, i) => l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V ? !!t : true, message: "请输入颜色", trigger: "blur" }] }, le = Ae(() => {
    let t = {};
    return v.value ? t = { plateId: [{ validator: ae, message: "请选择板型", trigger: "change" }] } : t = { plate: [{ validator: ae, message: "请选择板型", trigger: "change" }] }, { ...Ee, ...t };
  });
  function be({ row: t, column: i }) {
    if (!t) return;
    const r = le.value;
    let s = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[i.property] === false && (s = ye(i.property, r[i.property], t)), s && (t.verify[i.property] = true)), s ? "" : "mask-td";
  }
  j(() => C.value, (t) => {
    t && (L.value = {}, Te(), l.query.projectId = C.value, l.toQuery());
  }, { immediate: true, deep: true }), j(() => Y.value, (t) => {
    U.value = [], J(t) && (ge.forEach((i) => {
      t.projectContentList.findIndex((r) => Number(r.no) === i.no) > -1 && U.value.push(i);
    }), ee.value = U.value.length > 0);
  }, { deep: true, immediate: true }), j(() => l.query, (t) => {
    q();
  }, { deep: true, immediate: true });
  function Ve(t) {
    t.attachmentId && Z(t);
  }
  Se();
  async function Se() {
    try {
      const { technicalType: t = true } = await dt();
      v.value = t, ke();
    } catch (t) {
      console.log("获取技术交底配置状态", t), v.value = true;
    }
  }
  async function ke() {
    if (S.value = {}, !(v.value || !l.query.category || l.query.category === n.BENDING.V)) try {
      const { content: t = [] } = await et(l.query.category) || {}, i = {};
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? S.value.plate_type = t.map((r) => {
        let s = "";
        return r == null || r.list.forEach((p) => {
          p.name === "effectiveWidth" && (s = p.value);
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
  async function Ne(t, i) {
    try {
      const r = i === 1 ? "启用" : "暂停";
      await We.confirm("确定" + r + "?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await nt(t.id, { boolStatusEnum: !!i }), l.notify(`“${t.name}”已【${r}】`, O.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (r) {
      console.log("修改围护状态", r), t.boolStatusEnum = t.boolStatusEnum === I.PROCESS.V ? I.PAUSE.V : I.PROCESS.V;
    }
  }
  function Re() {
    z.success("上传成功"), l.toQuery();
  }
  function oe() {
    E.value = l.query.category !== n.BENDING.V ? D.value[l.query.category] : [];
  }
  async function Te() {
    try {
      const t = await tt(C.value);
      J(t) && (D.value = { [n.PROFILED_PLATE.V]: t.profiledPlateList || [], [n.PRESSURE_BEARING_PLATE.V]: t.pressureBearingPlateList || [], [n.TRUSS_FLOOR_PLATE.V]: t.trussFloorPlateList || [], [n.SANDWICH_BOARD.V]: t.sandwichBoardList || [] }), oe();
    } catch (t) {
      console.log("获取技术交底", t);
    }
  }
  function ie(t, i) {
    var r;
    if (t.plateId) {
      const s = E.value.find((p) => p.id === t.plateId);
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? (l.data[i].plate = s.serialNumber, l.data[i].weightMeter = s.weightMeter) : (l.data[i].plate = s.plateType, l.data[i].brand = s.brand, l.data[i].thickness = s.thickness, l.data[i].color = s.colour, l.data[i].unfoldedWidth = s.unfoldedWidth), l.data[i].width = s.effectiveWidth;
    } else {
      const s = ((r = S.value.KV) == null ? void 0 : r[t.plate]) || {};
      l.query.category === n.TRUSS_FLOOR_PLATE.V ? l.data[i].width = +s.effectiveWidth : (l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V) && (l.data[i].width = +s.effectiveWidth, l.data[i].unfoldedWidth = +s.unfoldedWidth);
    }
    R(t);
  }
  function R(t) {
    t.length && t.quantity && (t.totalLength = t.length * t.quantity / 1e3, re(t)), l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V ? t.length && t.quantity && t.unfoldedWidth && (t.totalArea = t.unfoldedWidth * t.length * t.quantity / 1e6) : t.length && t.quantity && t.width && (t.totalArea = t.width * t.length * t.quantity / 1e6);
  }
  function re(t) {
    l.query.category === n.BENDING.V || l.query.category === n.PROFILED_PLATE.V || l.query.category === n.PRESSURE_BEARING_PLATE.V ? t.unfoldedWidth && t.thickness && t.totalLength && (t.totalWeight = t.unfoldedWidth / 1e3 * t.thickness * t.totalLength * 7.85) : l.query.category === n.TRUSS_FLOOR_PLATE.V && t.weightMeter && t.totalLength && (t.totalWeight = t.weightMeter * t.totalLength);
  }
  function Ie() {
    if (l.query.category !== n.BENDING.V && E.value.length <= 0) {
      z.error("请先前往合同管理添加技术交底");
      return;
    }
    l.data.unshift({ id: void 0, areaId: l.query.areaId, isModify: true, dataIndex: l.data.length });
  }
  const ne = _({});
  function Ce(t) {
    if (ne.value = JSON.parse(JSON.stringify(t)), v.value) {
      const i = E.value.find((r) => r.plateType === t.plate);
      t.plateId = J(i) ? i.id : void 0;
    }
    t.isModify = true;
  }
  const Le = (t) => {
    P.value = t, B.value = true;
  };
  function Pe(t) {
    if (t.id) t = Object.assign(t, JSON.parse(JSON.stringify(ne.value))), t.isModify = false;
    else {
      const i = l.data.findIndex((r) => r.dataIndex === t.dataIndex);
      l.data.splice(i, 1);
    }
  }
  async function Ue(t) {
    l.query.category !== n.BENDING.V && l.data.map((p) => {
      if (!p.isModify && p.plate && v.value) {
        const F = E.value.find((G) => G.plateType === p.plate);
        p.plateId = F.id;
      }
    });
    const i = le.value;
    let r = true;
    t.verify = {};
    for (const p in i) t.verify[p] = ye(p, i[p], t), t.verify[p] || (r = false);
    if (console.log(t), !r) {
      z.error("请填写表格中标红数据");
      return;
    }
    const s = t.id ? "修改" : "新增";
    try {
      t.id ? await K.edit(t) : await K.add(t), l.notify(`${s}成功`, O.NOTIFICATION_TYPE.SUCCESS), q(), t.isModify = false;
    } catch (p) {
      console.log(s, p);
    }
  }
  function Oe(t) {
    W.value = true, P.value = t;
  }
  O.HOOK.handleRefresh = (t, i) => (i.data.content.length > 0 && i.data.content.forEach((r) => {
    r.type = t.query.type;
  }), i);
  async function q() {
    if (l.query.enclosurePlanId && l.query.category) try {
      L.value = await at({ ...l.query });
    } catch (t) {
      console.log("获取围护汇总", t);
    }
    else L.value = {};
  }
  return O.HOOK.afterSubmit = (t, i) => {
    q();
  }, (t, i) => {
    var ue, se;
    const r = Fe, s = Ge, p = $e, F = je, G = Qe, de = Q("common-select"), k = He, N = Q("common-button"), qe = ze, Me = Q("common-table"), $ = De("permission"), xe = Ke;
    return o(), y("div", ft, [ee.value ? (o(), y(M, { key: 0 }, [H("div", pt, [g(a(yt), { "project-id": a(C), onTableAdd: Ie, "table-data": D.value, globalProject: a(Y), typeOption: U.value, onCategoryChange: oe, sumData: L.value, onSumChange: q }, null, 8, ["project-id", "table-data", "globalProject", "typeOption", "sumData"])]), x((o(), u(Me, { ref_key: "tableRef", ref: te, data: a(l).data, "empty-text": a(l).emptyText, "max-height": a(we), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, onSortChange: a(l).handleSortChange, class: "enclosure-table", "cell-class-name": be }, { default: m(() => [g(r, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }), a(h).visible("name") ? (o(), u(r, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "120" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.name, "onUpdate:modelValue": (d) => e.row.name = d, placeholder: "名称", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", gt, f(e.row.name ? e.row.name : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("serialNumber") && a(l).query.category !== a(n).BENDING.V ? (o(), u(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.serialNumber, "onUpdate:modelValue": (d) => e.row.serialNumber = d, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", _t, f(e.row.serialNumber), 1))]), _: 1 })) : c("", true), a(h).visible("serialNumber") && a(l).query.category === a(n).BENDING.V ? (o(), u(r, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120px" }, { header: m(() => [g(G, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: m(() => [H("div", wt, [i[3] || (i[3] = H("span", null, "编号", -1)), g(F, null, { default: m(() => [g(p)]), _: 1 })])]), _: 1 })]), default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.serialNumber, "onUpdate:modelValue": (d) => e.row.serialNumber = d, placeholder: "编号", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("span", { key: 1, style: { cursor: "pointer" }, onDblclick: (d) => Ve(e.row) }, f(e.row.serialNumber), 41, vt))]), _: 1 })) : c("", true), a(h).visible("plateId") && a(l).query.category !== a(n).BENDING.V ? (o(), u(r, { key: v.value ? "plateId" : "plate", prop: v.value ? "plateId" : "plate", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" }, { default: m((e) => {
      var d;
      return [e.row.isModify && !e.row.inProductionQuantity ? (o(), y(M, { key: 0 }, [v.value ? (o(), u(de, { key: 0, modelValue: e.row.plateId, "onUpdate:modelValue": (T) => e.row.plateId = T, options: E.value, type: "other", dataStructure: a(l).query.category === a(n).TRUSS_FLOOR_PLATE.V ? pe : fe, size: "default", placeholder: "板型", onChange: (T) => ie(e.row, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "dataStructure", "onChange"])) : (o(), u(de, { key: 1, modelValue: e.row.plate, "onUpdate:modelValue": (T) => e.row.plate = T, options: (d = S.value) == null ? void 0 : d.plate_type, dataStructure: { key: "name", label: "name", value: "name" }, size: "default", placeholder: "板型", onChange: (T) => ie(e.row, e.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))], 64)) : (o(), y("div", Et, f(e.row.plate ? e.row.plate : "-"), 1))];
    }), _: 1 }, 8, ["prop"])) : c("", true), a(h).visible("width") && a(l).query.category !== a(n).BENDING.V ? (o(), u(r, { key: "width", prop: "width", "show-overflow-tooltip": true, label: a(l).query.category === a(n).SANDWICH_BOARD.V ? `宽度
(mm)` : `有效宽度
(mm)`, "min-width": "100px" }, { default: m((e) => [e.row.isModify && a(l).query.category !== a(n).PROFILED_PLATE.V && a(l).query.category !== a(n).PRESSURE_BEARING_PLATE.V && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.width, "onUpdate:modelValue": (d) => e.row.width = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_W__MM, placeholder: "有效宽度", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), y("div", bt, f(e.row.width ? e.row.width.toFixed(a(w).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 }, 8, ["label"])) : c("", true), a(h).visible("unfoldedWidth") && (a(l).query.category === a(n).BENDING.V || a(l).query.category === a(n).PROFILED_PLATE.V || a(l).query.category === a(n).PRESSURE_BEARING_PLATE.V) ? (o(), u(r, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": true, label: `展开宽度
(mm)`, "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity && a(l).query.category === a(n).BENDING.V ? (o(), u(k, { key: 0, modelValue: e.row.unfoldedWidth, "onUpdate:modelValue": (d) => e.row.unfoldedWidth = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_W__MM, placeholder: "展开宽度", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), y("div", Vt, f(e.row.unfoldedWidth ? e.row.unfoldedWidth.toFixed(a(w).MES_ENCLOSURE_W__MM) : "-"), 1))]), _: 1 })) : c("", true), a(l).query.category === a(n).BENDING.V ? (o(), u(r, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": true, label: "折弯次数", width: "80px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.bendTimes, "onUpdate:modelValue": (d) => e.row.bendTimes = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: 0, placeholder: "折弯次数", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("span", St, f(e.row.bendTimes ? e.row.bendTimes : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("thickness") && a(l).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (o(), u(r, { key: "thickness", prop: "thickness", "show-overflow-tooltip": true, label: `板厚
(mm)`, align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.thickness, "onUpdate:modelValue": (d) => e.row.thickness = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_T__MM, placeholder: "板厚", "controls-position": "right", style: { width: "100%" }, onChange: (d) => re(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), y("span", kt, f(e.row.thickness ? e.row.thickness.toFixed(a(w).MES_ENCLOSURE_T__MM) : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("length") ? (o(), u(r, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `单长
(㎜)`, align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.length, "onUpdate:modelValue": (d) => e.row.length = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_L__MM, placeholder: "单长", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), y("span", Nt, f(e.row.length ? e.row.length.toFixed(a(w).MES_ENCLOSURE_L__MM) : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("quantity") ? (o(), u(r, { key: "quantity", prop: "quantity", label: "数量(张)", align: "left", "min-width": "100px" }, { default: m((e) => [e.row.isModify && !e.row.inProductionQuantity ? (o(), u(k, { key: 0, modelValue: e.row.quantity, "onUpdate:modelValue": (d) => e.row.quantity = d, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: a(w).MES_ENCLOSURE_L__MM, placeholder: "数量", "controls-position": "right", style: { width: "100%" }, onChange: (d) => R(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (o(), y("span", Rt, f(e.row.quantity), 1))]), _: 1 })) : c("", true), a(h).visible("totalArea") ? (o(), u(r, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": true, label: "总面积(㎡)", align: "left", "min-width": "100px" }, { default: m((e) => [b(f(e.row.totalArea ? e.row.totalArea.toFixed(a(w).COM_ENCLOSURE_AREA__M2) : "-"), 1)]), _: 1 })) : c("", true), a(h).visible("totalLength") ? (o(), u(r, { key: "totalLength", prop: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px" }, { default: m((e) => [b(f(e.row.totalLength ? e.row.totalLength.toFixed(a(w).MES_ENCLOSURE_L__M) : "-"), 1)]), _: 1 })) : c("", true), a(l).query.category !== a(n).SANDWICH_BOARD.V ? (o(), u(r, { key: "totalWeight", prop: "totalWeight", label: "总重量(kg)", align: "left", "min-width": "100px" }, { default: m((e) => [b(f(e.row.totalWeight ? e.row.totalWeight.toFixed(a(w).COM_WT__KG) : "-"), 1)]), _: 1 })) : c("", true), a(h).visible("coating") ? (o(), u(r, { key: "coating", prop: "coating", "show-overflow-tooltip": true, label: "涂层", width: "100px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.coating, "onUpdate:modelValue": (d) => e.row.coating = d, placeholder: "涂层", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", Tt, f(e.row.coating ? e.row.coating : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("plating") ? (o(), u(r, { key: "plating", prop: "plating", "show-overflow-tooltip": true, label: "镀层", width: "80px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.plating, "onUpdate:modelValue": (d) => e.row.plating = d, placeholder: "镀层", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", It, f(e.row.plating ? e.row.plating : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("brand") && a(l).query.category !== a(n).SANDWICH_BOARD.V && a(l).query.category !== a(n).TRUSS_FLOOR_PLATE.V ? (o(), u(r, { key: "brand", prop: "brand", "show-overflow-tooltip": true, label: "品牌", width: "100px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.brand, "onUpdate:modelValue": (d) => e.row.brand = d, placeholder: "品牌", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", Ct, f(e.row.brand ? e.row.brand : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("color") && a(l).query.category != a(n).TRUSS_FLOOR_PLATE.V && a(l).query.category != a(n).PRESSURE_BEARING_PLATE.V && a(l).query.category != a(n).SANDWICH_BOARD.V ? (o(), u(r, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", width: "80px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.color, "onUpdate:modelValue": (d) => e.row.color = d, placeholder: "颜色", maxlength: "10", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", Lt, f(e.row.color ? e.row.color : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("remark") ? (o(), u(r, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120px" }, { default: m((e) => [e.row.isModify ? (o(), u(s, { key: 0, modelValue: e.row.remark, "onUpdate:modelValue": (d) => e.row.remark = d, placeholder: "备注", type: "textarea", maxlength: "200", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), y("div", Pt, f(e.row.remark ? e.row.remark : "-"), 1))]), _: 1 })) : c("", true), a(h).visible("draw") && a(l).query.category === a(n).BENDING.V ? (o(), u(r, { key: "draw", prop: "draw", "show-overflow-tooltip": true, label: "画图", "min-width": "190px" }, { default: m((e) => [g(a(ct), { "upload-fun": a(lt), data: { id: e.row.id }, fileClassify: void 0, accept: ".jpg,.jpeg,.png", "success-msg": "上传成功", "btn-name": "上传", "btn-type": "warning", "btn-size": "default", onSuccess: Re, style: { display: "inline-block", "margin-right": "5px" } }, null, 8, ["upload-fun", "data"]), x((o(), u(N, { size: "default", type: "primary", onClick: (d) => Oe(e.row), disabled: e.row.isModify }, { default: m(() => [b(f(e.row.attachmentId ? "换图" : "画图"), 1)]), _: 2 }, 1032, ["onClick", "disabled"])), [[$, a(V).draw]]), e.row.attachmentId ? x((o(), u(N, { key: 0, size: "default", type: "primary", icon: "el-icon-view", onClick: (d) => a(Z)(e.row) }, null, 8, ["onClick"])), [[$, a(V).drawDownload]]) : c("", true)]), _: 1 })) : c("", true), a(h).visible("createTime") ? (o(), u(r, { key: "createTime", prop: "createTime", label: "上传时间", align: "center", "show-overflow-tooltip": "", width: "110" }, { default: m((e) => [b(f(e.row.createTime ? a(ot)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : c("", true), a(h).visible("userName") ? (o(), u(r, { key: "userName", prop: "userName", label: "上传人", align: "center", "show-overflow-tooltip": "", width: "100" })) : c("", true), a(h).visible("status") ? (o(), u(r, { key: "status", prop: "status", label: "状态", align: "center", width: "70px", fixed: "right" }, { default: m((e) => [e.row.id ? (o(), u(qe, { key: 0, modelValue: e.row.boolStatusEnum, "onUpdate:modelValue": (d) => e.row.boolStatusEnum = d, disabled: !a(ce)(a(V).edit), "active-color": "#13ce66", "active-value": a(I).PROCESS.V, "inactive-value": a(I).PAUSE.V, onChange: (d) => Ne(e.row, e.row.boolStatusEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])) : c("", true)]), _: 1 })) : c("", true), a(ce)([...a(V).edit, ...a(V).del]) ? (o(), u(r, { key: 22, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: m((e) => [e.row.isModify ? (o(), y(M, { key: 0 }, [g(N, { type: "info", size: "default", onClick: (d) => Pe(e.row) }, { default: m(() => i[4] || (i[4] = [b("取消")])), _: 2, __: [4] }, 1032, ["onClick"]), g(N, { type: "primary", size: "default", onClick: (d) => Ue(e.row) }, { default: m(() => i[5] || (i[5] = [b("保存")])), _: 2, __: [5] }, 1032, ["onClick"])], 64)) : (o(), y(M, { key: 1 }, [x(g(N, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (d) => Ce(e.row) }, null, 8, ["onClick"]), [[$, a(V).edit]]), g(N, { size: "default", icon: "el-icon-view", type: "success", onClick: (d) => Le(e.row) }, null, 8, ["onClick"])], 64))]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[xe, a(l).loading]]), g(a(it)), g(a(ht)), g(a(st), { ref_key: "simpleDrawRef", ref: he, modelValue: W.value, "onUpdate:modelValue": i[0] || (i[0] = (e) => W.value = e), current: P.value, onToQuery: a(l).toQuery }, null, 8, ["modelValue", "current", "onToQuery"]), g(rt, { modelValue: a(A), "onUpdate:modelValue": i[1] || (i[1] = (e) => Be(A) ? A.value = e : null), "serial-number": (ue = a(X)) == null ? void 0 : ue.serialNumber, attachmentId: (se = a(X)) == null ? void 0 : se.attachmentId }, null, 8, ["modelValue", "serial-number", "attachmentId"]), g(ut, { visible: B.value, "onUpdate:visible": i[2] || (i[2] = (e) => B.value = e), detailInfo: P.value }, null, 8, ["visible", "detailInfo"])], 64)) : (o(), y("span", Ut, "当前项目内容没有包含围护制品，请到合同管理中进行配置"))]);
  };
} }, sa = Je(Ot, [["__scopeId", "data-v-b8a7174e"]]);
export {
  sa as default
};
