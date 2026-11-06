import { computed as J } from "vue";
import { ref as m } from "vue";
import { watch as Pe } from "vue";
import { resolveComponent as se } from "vue";
import { openBlock as d } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as b } from "vue";
import { toDisplayString as A } from "vue";
import { unref as S } from "vue";
import { createTextVNode as R } from "vue";
import { createCommentVNode as X } from "vue";
import { Fragment as G } from "vue";
import { renderList as K } from "vue";
import { ElMessage as C } from "element-plus";
import { nextTick as Be } from "vue";
import { ElTabPane as qe } from "element-plus";
import { ElTabs as Re } from "element-plus";
import { ElTableColumn as De } from "element-plus";
import { ElRadio as Ie } from "element-plus";
import { ElRadioGroup as Ue } from "element-plus";
import { ElFormItem as xe } from "element-plus";
import { ElInput as Le } from "element-plus";
import { ElOption as Ae } from "element-plus";
import { ElSelect as $e } from "element-plus";
import { ElForm as ze } from "element-plus";
import { ElInputNumber as Oe } from "element-plus";
import { _ as Ge, bY as Ke, i as E, G as Me, op as Qe, kb as We } from "../../../../shared/runtime.js";
import je from "./statistics-report.vue.js";
import { c as $ } from "./list-detail-dialog.vue.js";
const Ye = { class: "paint-calc-container" }, He = { key: 0, class: "calc-content" }, Je = { class: "content-layout" }, Xe = { class: "left-panel" }, Ze = { class: "process-number" }, ea = { key: 1, class: "empty-tip" }, aa = { class: "middle-panel" }, na = { class: "panel-header" }, ta = { class: "panel-actions" }, ia = { class: "paint-section" }, la = { class: "paint-item" }, sa = { key: 0 }, oa = { class: "section-title" }, ra = { class: "paint-item" }, ua = { key: 0, class: "usage-display" }, da = { key: 1, class: "usage-display" }, pa = { key: 1, class: "empty-tip" }, ca = { key: 1, class: "report-content" }, va = { __name: "paint-calc-dialog", props: { modelValue: { type: Boolean, default: false }, rowData: { type: Object, default: null } }, emits: ["update:modelValue", "success"], setup(oe, { emit: re }) {
  var ie, le;
  const v = oe, M = re, Z = J({ get: () => v.modelValue, set: (e) => M("update:modelValue", e) }), D = m("calc"), Q = m("-"), W = m(), F = m(), T = m(false), g = m({ processType: 1, processSheetName: `${(ie = v.rowData) == null ? void 0 : ie.serialNumber}-${((le = v.rowData) == null ? void 0 : le.maxCalculateNumber) + 1}` || "", processSheetId: void 0 }), I = m([]), w = m(void 0), j = m(false), ue = J(() => {
    const e = { processType: [{ required: true, message: "请选择工艺单选项", trigger: "change" }] };
    return g.value.processType === 1 ? e.processSheetName = [{ required: true, message: "请输入工艺单名称或编号", trigger: "blur" }] : e.processSheetId = [{ required: true, message: "请选择工艺单", trigger: "change" }], e;
  }), de = [1, 2, 4];
  Pe(() => v.modelValue, (e) => {
    var a;
    e ? ((a = v.rowData) != null && a.serialNumber && v.rowData.serialNumber !== "-" ? Q.value = v.rowData.serialNumber : Q.value = "-", ae(), me(), W.value && (W.value.clearSelection(), B.value = []), D.value = "calc", ee(), Y(), pe()) : (j.value && M("success"), j.value = false, N.value = []);
  });
  function pe() {
    var e, a;
    g.value = { processType: 1, processSheetName: `${(e = v.rowData) == null ? void 0 : e.serialNumber}-${((a = v.rowData) == null ? void 0 : a.maxCalculateNumber) + 1}`, processSheetId: void 0 }, F.value && F.value.clearValidate();
  }
  async function Y() {
    var a;
    const e = (a = v.rowData) == null ? void 0 : a.id;
    if (!e) {
      I.value = [];
      return;
    }
    try {
      const n = await $.getPaintCalculateRecordList({ paintTechnologyId: e });
      I.value = (n == null ? void 0 : n.content) || [];
    } catch (n) {
      console.log("获取历史工艺单失败", n), I.value = [];
    }
  }
  function ce(e) {
    var a, n;
    e === 1 ? (g.value.processSheetName = `${(a = v.rowData) == null ? void 0 : a.serialNumber}-${((n = v.rowData) == null ? void 0 : n.maxCalculateNumber) + 1}`, g.value.processSheetId = void 0, w.value = void 0) : g.value.processSheetName = "", F.value && F.value.clearValidate();
  }
  function ve(e) {
    const a = I.value.find((n) => n.id === e);
    if (a) {
      g.value.processSheetName = a.serialNumber;
      const n = a.paintCalculateConsumptionList || [];
      h.value.forEach((t) => {
        const i = n.find((c) => c.paintingTypeEnum === t.paintingTypeEnum);
        i && (t.paintBrand = i.paintBrand, t.paintType = i.paintType, t.paintColor = i.paintColor, t.paintFilmThickness = i.paintThickness, t.lossFactor = i.lossCoefficient, t.paintConfigId = i.paintConfigId, t.paintBrand && t.paintType && O(t));
      });
    } else g.value.processSheetName = "", ae();
    w.value = a || void 0;
  }
  const N = m([]), U = J(() => !N.value || N.value.length === 0);
  async function ee() {
    var e;
    try {
      if ((e = v.rowData) != null && e.id) {
        const a = await $.getPaintCalcList({ paintTechnologyId: v.rowData.id });
        if (a && a.content && a.content.length > 0) {
          N.value = a.content;
          return;
        }
      }
      N.value = [];
    } catch (a) {
      console.error("加载清单数据失败", a), N.value = [];
    }
  }
  const h = m([]), z = m(/* @__PURE__ */ new Map());
  function ge(e, a) {
    e && (a ? z.value.set(e, a) : z.value.delete(e));
  }
  const fe = { area: [{ trigger: ["blur", "change"], required: true, validator: (e, a, n) => {
    const t = Number(a);
    if (!Number.isFinite(t) || t <= 0) return n(new Error("涂装面积必须大于0"));
    n();
  } }], paintBrand: [{ required: true, message: "请选择油漆品牌", trigger: "change" }], paintType: [{ required: true, message: "请选择油漆材质", trigger: "change" }], paintFilmThickness: [{ trigger: ["blur", "change"], required: true, validator: (e, a, n) => {
    const t = Number(a);
    if (!Number.isFinite(t) || t <= 0) return n(new Error("请输入漆膜厚度"));
    n();
  } }], lossFactor: [{ trigger: ["blur", "change"], required: true, validator: (e, a, n) => {
    const t = Number(a);
    if (!Number.isFinite(t) || t <= 0) return n(new Error("请输入损耗系数"));
    n();
  } }] };
  function H(e) {
    const a = Number(e);
    return Number.isFinite(a) ? a : 0;
  }
  function ae() {
    var t;
    const e = ((t = v.rowData) == null ? void 0 : t.paintTechnologyDetailList) || [], a = ne(), n = /* @__PURE__ */ new Map();
    e.filter((i) => de.includes(i.paintingTypeEnum)).forEach((i) => {
      n.has(i.paintingTypeEnum) || n.set(i.paintingTypeEnum, []), n.get(i.paintingTypeEnum).push(i);
    }), h.value = Array.from(n.entries()).sort((i, c) => i[0] - c[0]).map(([i, c]) => {
      var q, L;
      const s = (c == null ? void 0 : c[0]) || {}, y = s.paintFilmThickness != null ? String(s.paintFilmThickness) : "", k = s.paintBrand || "", p = s.paintType || "", _ = s.paintConfigId != null ? Number(s.paintConfigId) : void 0, P = s.paintColor || "";
      return { paintingTypeEnum: i, label: ((L = (q = Ke) == null ? void 0 : q.VL) == null ? void 0 : L[i]) || (i === 1 ? "底漆" : i === 2 ? "中间漆" : "面漆"), originalPaintConfigId: _, originalPaintBrand: k, originalPaintType: p, originalPaintColor: P, originalPaintFilmThickness: y, paintConfigId: _, paintBrand: k, paintType: p, paintColor: P, defaultPaintFilmThickness: y, paintFilmThickness: y, area: a, lossFactor: "", paintConfig: void 0, weight: void 0, quantity: void 0, packageUnit: void 0 };
    }), h.value.forEach((i) => {
      i.paintBrand && i.paintType && O(i);
    });
  }
  function ne() {
    return (B.value || []).reduce((a, n) => a + (n.totalArea || 0), 0);
  }
  const x = m({});
  async function me() {
    const a = h.value.map((n) => n.paintingTypeEnum).map(async (n) => {
      try {
        const t = await $.getPaintConfigListAll({ paintingTypeEnum: n }), i = Array.isArray(t) ? t : (t == null ? void 0 : t.content) || [];
        x.value[n] = i;
      } catch (t) {
        console.error(`获取油漆配置失败 type=${n}`, t), x.value[n] = [];
      }
    });
    await Promise.all(a);
  }
  function he(e) {
    const a = x.value[e] || [], n = new Set(a.map((t) => t.paintBrand).filter(Boolean));
    return Array.from(n);
  }
  function ye(e, a) {
    return (x.value[e] || []).filter((i) => i.paintBrand === a && i.paintType).map((i) => ({ paintConfigId: i.id || i.paintConfigId, paintType: i.paintType, paintColor: i.paintColor, paintFilmThickness: i.paintFilmThickness }));
  }
  function be(e, a, n) {
    const i = (x.value[e] || []).find((c) => c.paintBrand === a && c.paintType === n);
    if (i) return { paintConfigId: i.id || i.paintConfigId, paintType: i.paintType, paintColor: i.paintColor, paintFilmThickness: i.paintFilmThickness };
  }
  function _e(e) {
    e.paintType = "", e.paintConfigId = void 0, e.paintColor = "", e.defaultPaintFilmThickness = "", e.paintFilmThickness = "", e.paintConfig = void 0, e.weight = void 0, e.quantity = void 0, e.packageUnit = void 0;
  }
  async function O(e) {
    if (!(e != null && e.paintBrand) || !(e != null && e.paintType) || !(e != null && e.paintingTypeEnum)) return;
    const a = (e.__reqKey || 0) + 1;
    e.__reqKey = a;
    try {
      const n = await $.getPaintingCraftSelectList({ paintingTypeEnum: e.paintingTypeEnum, paintBrand: e.paintBrand, paintType: e.paintType }), t = (n == null ? void 0 : n.content) || [], i = t == null ? void 0 : t[0];
      if (e.__reqKey !== a) return;
      if (!i) {
        e.paintConfig = void 0, e.packageUnit = void 0;
        return;
      }
      e.paintConfig = i, e.paintConfigId == null && i.id != null && (e.paintConfigId = Number(i.id)), e.packageUnit = i.packageUnit;
    } catch (n) {
      console.error(n);
    }
  }
  async function Te(e) {
    const a = be(e.paintingTypeEnum, e.paintBrand, e.paintType);
    if (a) {
      e.paintConfigId = a.paintConfigId;
      const n = a.paintFilmThickness != null ? String(a.paintFilmThickness) : "";
      e.defaultPaintFilmThickness = n, e.paintFilmThickness = n, e.paintColor = a.paintColor || "";
    }
    await O(e), e.weight = void 0, e.quantity = void 0;
  }
  const B = m([]);
  function Ce(e) {
    B.value = e;
    const a = ne();
    h.value.forEach((n) => {
      n.area = a;
    });
  }
  async function we() {
    h.value.forEach((e) => {
      e.paintBrand = e.originalPaintBrand, e.paintType = e.originalPaintType, e.paintConfigId = e.originalPaintConfigId, e.paintColor = e.originalPaintColor, e.defaultPaintFilmThickness = e.originalPaintFilmThickness, e.paintFilmThickness = e.originalPaintFilmThickness, e.paintConfig = void 0, e.weight = void 0, e.quantity = void 0, e.packageUnit = void 0;
    }), await Promise.allSettled(h.value.map((e) => e.paintBrand && e.paintType ? O(e) : Promise.resolve())), C.success("已复原油漆品牌、材质及漆膜厚度");
  }
  async function te() {
    if (!B.value || B.value.length === 0) return C.error("请先在左侧清单列表中选择构件种类"), false;
    try {
      const a = Array.from(z.value.values()).filter(Boolean).map((n) => n.validate());
      return F.value && a.push(F.value.validate()), await Promise.all(a), true;
    } catch {
      return C.error("请完整填写右侧油漆计算信息及工艺单信息"), false;
    }
  }
  async function ke() {
    await te() && h.value.forEach((a) => {
      if (!E(a.paintConfig)) {
        a.weight = void 0, a.quantity = void 0;
        return;
      }
      Fe(a, a.paintFilmThickness, a.lossFactor);
    });
  }
  function Fe(e, a, n) {
    const t = e.paintConfig || {};
    t.lossCoefficient = n, t.paintFilmThickness = a;
    const i = Number(t.volumeSolidContent), c = Number(t.specificGravity), s = Number(a), y = Number(n), k = Number(e.area), p = Number(t.packageWeight);
    if (![i, c, s, y, k, p].every((_) => Number.isFinite(_))) {
      C.error("计算参数异常，请检查油漆配置和输入项！"), t.theoreticalCoatingRate = void 0, t.practicalSpreadingRate = void 0, e.weight = void 0, e.quantity = void 0;
      return;
    }
    if (c <= 0 || s <= 0 || y <= 0 || p <= 0) {
      C.error("比重、漆膜厚度、损耗系数和包装重量必须大于 0 ！"), t.theoreticalCoatingRate = void 0, t.practicalSpreadingRate = void 0, e.weight = void 0, e.quantity = void 0;
      return;
    }
    if (t.theoreticalCoatingRate = i * 10 / (c * s), t.practicalSpreadingRate = t.theoreticalCoatingRate / y, !Number.isFinite(t.practicalSpreadingRate) || t.practicalSpreadingRate <= 0) {
      C.error("实际涂布率异常，请检查输入参数"), e.weight = void 0, e.quantity = void 0;
      return;
    }
    if (e.weight = k / t.practicalSpreadingRate, !Number.isFinite(e.weight)) {
      C.error("需求重量计算异常"), e.quantity = void 0;
      return;
    }
    if (e.quantity = e.weight / p, !Number.isFinite(e.quantity)) {
      C.error("包装数量计算异常"), e.quantity = void 0;
      return;
    }
  }
  async function Ne() {
    var e, a;
    if (await te()) try {
      const n = (B.value || []).map((s) => s.structureClassId).filter((s) => s != null);
      if (h.value.some((s) => E(s.paintConfig) && (s.weight == null || s.quantity == null))) {
        C.error("请先进行油漆计算");
        return;
      }
      const i = h.value.map((s) => {
        const y = H(s.area), k = H(s.paintFilmThickness), p = H(s.lossFactor), _ = Number.isFinite(Number(s.weight)) ? Number(s.weight) : 0;
        return { groupQuantity: Number.isFinite(Number(s.quantity)) ? Number(s.quantity) : 0, paintWeight: _, lossCoefficient: p, paintConfigId: s.paintConfigId, paintThickness: k, paintingTypeEnum: s.paintingTypeEnum, totalArea: y };
      }), c = { id: (e = w.value) == null ? void 0 : e.id, paintTechnologyId: (a = v.rowData) == null ? void 0 : a.id, structureClassIdList: n, paintCalculateConsumptionList: i, serialNumber: g.value.processSheetName };
      await $.saveCalculate(c), C.success("保存成功"), M("success"), Y(), await Ve();
    } catch (n) {
      console.error("保存失败", n);
    }
  }
  async function Ve() {
    var e, a;
    T.value = true, g.value = { processType: 1, processSheetName: "", processSheetId: void 0 }, h.value.forEach((n) => {
      n.area = "", n.paintBrand = "", n.paintType = "", n.paintColor = "", n.paintFilmThickness = "", n.lossFactor = "", n.paintConfigId = void 0, n.paintConfig = void 0, n.weight = void 0, n.quantity = void 0, n.packageUnit = void 0;
    }), await Be(), (a = (e = F.value) == null ? void 0 : e.clearValidate) == null || a.call(e), Array.from(z.value.values()).forEach((n) => {
      var t;
      return (t = n == null ? void 0 : n.clearValidate) == null ? void 0 : t.call(n);
    }), T.value = false;
  }
  function Se() {
    j.value = true, Y(), ee();
  }
  return (e, a) => {
    const n = qe, t = Re, i = De, c = se("common-table"), s = se("common-button"), y = Ie, k = Ue, p = xe, _ = Le, P = Ae, q = $e, L = ze, Ee = Oe;
    return d(), V(We, { modelValue: Z.value, "onUpdate:modelValue": a[4] || (a[4] = (l) => Z.value = l), title: "详情", size: "100%", direction: "rtl", "show-close": true }, { content: r(() => [f("div", Ye, [o(t, { modelValue: D.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => D.value = l), class: "main-tabs" }, { default: r(() => [o(n, { label: "油漆计算", name: "calc" }), o(n, { label: "统计报表", name: "report" })]), _: 1 }, 8, ["modelValue"]), D.value === "calc" ? (d(), b("div", He, [f("div", Je, [f("div", Xe, [a[6] || (a[6] = f("div", { class: "panel-title" }, "清单列表", -1)), f("div", Ze, "工艺编号: " + A(Q.value), 1), N.value.length > 0 ? (d(), V(c, { key: 0, ref_key: "listTableRef", ref: W, data: N.value, "max-height": 400, style: { width: "100%" }, onSelectionChange: Ce }, { default: r(() => [o(i, { type: "selection", width: "55" }), o(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(i, { prop: "structureClassName", label: "构件类型", "min-width": "150px" }), o(i, { prop: "quantity", label: "总数量", align: "center", "min-width": "100px" }), o(i, { prop: "totalArea", label: "总面积(m²)", align: "center", "min-width": "100px" })]), _: 1 }, 8, ["data"])) : (d(), b("div", ea, a[5] || (a[5] = [f("div", null, "暂无需要计算的清单", -1)])))]), f("div", aa, [f("div", na, [a[10] || (a[10] = f("div", { class: "panel-title" }, "油漆计算器", -1)), f("div", ta, [o(s, { size: "default", onClick: we, disabled: S(E)(w.value) || U.value }, { default: r(() => a[7] || (a[7] = [R(" 一键复原 ")])), _: 1, __: [7] }, 8, ["disabled"]), o(s, { type: "primary", size: "default", onClick: ke, disabled: U.value }, { default: r(() => a[8] || (a[8] = [R(" 计算 ")])), _: 1, __: [8] }, 8, ["disabled"]), S(Me)(S(Qe).calcSave) ? (d(), V(s, { key: 0, type: "success", size: "default", onClick: Ne, disabled: U.value }, { default: r(() => a[9] || (a[9] = [R(" 保存 ")])), _: 1, __: [9] }, 8, ["disabled"])) : X("", true)])]), f("div", ia, [a[13] || (a[13] = f("div", { class: "section-title" }, "涂艺工单创建", -1)), f("div", la, [o(L, { ref_key: "processFormRef", ref: F, model: g.value, rules: ue.value, "label-width": "120px", size: "default", disabled: U.value }, { default: r(() => [o(p, { label: "工艺单选项", prop: "processType" }, { default: r(() => [o(k, { modelValue: g.value.processType, "onUpdate:modelValue": a[1] || (a[1] = (l) => g.value.processType = l), onChange: ce }, { default: r(() => [o(y, { label: 1 }, { default: r(() => a[11] || (a[11] = [R("新增工艺单")])), _: 1, __: [11] }), o(y, { label: 2 }, { default: r(() => a[12] || (a[12] = [R("使用原有工艺单")])), _: 1, __: [12] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), g.value.processType === 1 ? (d(), V(p, { key: 0, label: "工艺单", prop: "processSheetName" }, { default: r(() => [o(_, { modelValue: g.value.processSheetName, "onUpdate:modelValue": a[2] || (a[2] = (l) => g.value.processSheetName = l), placeholder: "录入名称或编号", disabled: "", "validate-event": !T.value, style: { width: "100%" }, maxlength: "50" }, null, 8, ["modelValue", "validate-event"])]), _: 1 })) : (d(), V(p, { key: 1, label: "工艺单", prop: "processSheetId" }, { default: r(() => [o(q, { modelValue: g.value.processSheetId, "onUpdate:modelValue": a[3] || (a[3] = (l) => g.value.processSheetId = l), filterable: "", clearable: "", placeholder: "请选择工艺单", "validate-event": !T.value, style: { width: "100%" }, onChange: ve }, { default: r(() => [(d(true), b(G, null, K(I.value, (l) => (d(), V(P, { key: l.id, label: `${l.serialNumber}`, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "validate-event"])]), _: 1 }))]), _: 1 }, 8, ["model", "rules", "disabled"])])]), h.value.length > 0 ? (d(), b("div", sa, [(d(true), b(G, null, K(h.value, (l) => (d(), b("div", { key: l.paintingTypeEnum, class: "paint-section" }, [f("div", oa, A(l.label), 1), f("div", ra, [o(L, { ref_for: true, ref: (u) => ge(l.paintingTypeEnum, u), model: l, rules: fe, "label-width": "120px", size: "default", disabled: U.value }, { default: r(() => [o(p, { label: "涂装面积", prop: "area" }, { default: r(() => [o(Ee, { modelValue: l.area, "onUpdate:modelValue": (u) => l.area = u, min: 0, precision: 2, "validate-event": !T.value, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "validate-event"])]), _: 2 }, 1024), o(p, { label: "油漆品牌", prop: "paintBrand" }, { default: r(() => [o(q, { modelValue: l.paintBrand, "onUpdate:modelValue": (u) => l.paintBrand = u, filterable: "", clearable: "", disabled: S(E)(w.value), placeholder: "选择品牌", "validate-event": !T.value, style: { width: "100%" }, onChange: () => _e(l) }, { default: r(() => [(d(true), b(G, null, K(he(l.paintingTypeEnum), (u) => (d(), V(P, { key: u, label: u, value: u }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "validate-event", "onChange"])]), _: 2 }, 1024), o(p, { label: "油漆材质", prop: "paintType" }, { default: r(() => [o(q, { modelValue: l.paintType, "onUpdate:modelValue": (u) => l.paintType = u, filterable: "", clearable: "", disabled: S(E)(w.value), placeholder: "选择材质", "validate-event": !T.value, style: { width: "100%" }, onChange: () => Te(l) }, { default: r(() => [(d(true), b(G, null, K(ye(l.paintingTypeEnum, l.paintBrand), (u) => (d(), V(P, { key: `${u.paintConfigId ?? ""}-${u.paintType}`, label: u.paintType, value: u.paintType }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "validate-event", "onChange"])]), _: 2 }, 1024), o(p, { label: "油漆颜色" }, { default: r(() => [o(_, { modelValue: l.paintColor, "onUpdate:modelValue": (u) => l.paintColor = u, disabled: S(E)(w.value), placeholder: "自动带出/可修改", "validate-event": !T.value, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "validate-event"])]), _: 2 }, 1024), o(p, { label: "漆膜厚度", prop: "paintFilmThickness" }, { default: r(() => [o(_, { modelValue: l.paintFilmThickness, "onUpdate:modelValue": (u) => l.paintFilmThickness = u, disabled: S(E)(w.value), placeholder: "填写厚度", "validate-event": !T.value, style: { width: "100%" } }, { append: r(() => a[14] || (a[14] = [R("um")])), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "validate-event"])]), _: 2 }, 1024), o(p, { label: "损耗系数", prop: "lossFactor" }, { default: r(() => [o(_, { modelValue: l.lossFactor, "onUpdate:modelValue": (u) => l.lossFactor = u, disabled: S(E)(w.value), placeholder: "填写损耗系数", "validate-event": !T.value, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "validate-event"])]), _: 2 }, 1024), o(p, { label: "用量" }, { default: r(() => [l.weight && l.quantity ? (d(), b("div", ua, A(l.weight.toFixed(2)) + "kg / " + A(l.quantity.toFixed(2)) + A(l.packageUnit || ""), 1)) : (d(), b("div", da, "-"))]), _: 2 }, 1024)]), _: 2 }, 1032, ["model", "disabled"])])]))), 128))])) : (d(), b("div", pa, a[15] || (a[15] = [f("div", null, "暂无油漆配置", -1)])))])])])) : X("", true), D.value === "report" ? (d(), b("div", ca, [o(je, { "row-data": v.rowData, onRefresh: Se }, null, 8, ["row-data"])])) : X("", true)])]), _: 1 }, 8, ["modelValue"]);
  };
} }, _a = Ge(va, [["__scopeId", "data-v-64d7afbb"]]);
export {
  _a as default
};
