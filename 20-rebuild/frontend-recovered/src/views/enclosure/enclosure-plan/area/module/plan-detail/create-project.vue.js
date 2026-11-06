import { provide as z } from "vue";
import { computed as le } from "vue";
import { ref as o } from "vue";
import { watchEffect as Y } from "vue";
import { reactive as pe } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as y } from "vue";
import { createBlock as I } from "vue";
import { withCtx as E } from "vue";
import { createVNode as M } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementBlock as oe } from "vue";
import { createCommentVNode as G } from "vue";
import { unref as c } from "vue";
import { isRef as ce } from "vue";
import { nextTick as ue } from "vue";
import { ElMessage as De } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElFormItem as he } from "element-plus";
import { ElForm as me } from "element-plus";
import { _ as Ee, u as Se, o as Te, mc as ge, V as W, cM as ye, i as D, aI as be, p as J, gD as _e, mv as v } from "../../../../../../shared/runtime.js";
import ve from "./custom-monomer-form.vue.js";
import xe from "./subitemType-plan-table.vue.js";
import Ne from "./create-dept-plan.vue.js";
const Le = { key: 0, style: { color: "#e6a23c" } }, Ie = { style: { color: "#67c23a" } }, Me = { style: { color: "#67c23a", "margin-left": "10px" } }, Re = { __name: "create-project", props: { modelValue: { type: Boolean, require: true }, projectInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(f, { emit: K }) {
  const x = f;
  z("projectInfo", le(() => x.projectInfo));
  const Q = K, { visible: R, handleClose: X } = Se({ emit: Q, props: x, showHook: w, closeHook: de }), { maxHeight: A } = Te({ mainBox: ".project-plan-container-drawer", extraBox: [".el-drawer__header", ".project-plan-steps"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }), H = o(), d = o(), P = o(1), m = o();
  o(false);
  const j = o(false), S = o([]), T = o([]);
  o(false);
  const O = o(false), N = o({}), k = o(false);
  z("lumpSumSystemType", m);
  const Z = (t) => {
    console.log(t), d.value.forEach((n) => {
      n.areaList.forEach((a) => {
        t === v.NO_FACTORY_PROCESSING_NEED_CONTROL.V ? (a.shippingTimes = [], a.deepenTimes = [], a.purchaseTimes = [], a.processTimes = []) : t === v.NO_FACTORY_PROCESSING_NO_CONTROL.V ? (a.shippingTimes = [], a.deepenTimes = [], a.purchaseTimes = [], a.processTimes = [], a.installTimes = []) : t === v.NEED_FACTORY_PROCESSING_NO_CONTROL.V && (a.installTimes = []);
      });
    });
  };
  function w() {
    P.value = 1, m.value = void 0, ee();
  }
  async function ee() {
    var t, n, a, e;
    j.value = true;
    try {
      d.value = [], S.value = [], T.value = [];
      const l = await ge({ projectId: (t = x.projectInfo) == null ? void 0 : t.projectId });
      m.value = (n = l.monomerList) == null ? void 0 : n.lumpSumSystemType, ((a = l.monomerList) == null ? void 0 : a.length) === 0 ? k.value = true : k.value = false, d.value = ((e = l.monomerList) == null ? void 0 : e.map((i) => {
        var g;
        return m.value = i.lumpSumSystemType, (g = i.areaList) == null || g.forEach((h) => {
          h.deliveryStartDate && h.deliveryEndDate ? h.deliveryDate = [h.deliveryStartDate, h.deliveryEndDate] : h.deliveryDate = null;
        }), i.sourceRow = W({ name: i.name, itemizedType: i.itemizedType, mete: i.mete, remark: i.remark, type: i.type }), i.sourcePlanRow = W({ startDate: i.startDate, endDate: i.endDate, deepenStartDate: i.deepenStartDate, deepenEndDate: i.deepenEndDate, purchaseStartDate: i.purchaseStartDate, purchaseEndDate: i.purchaseEndDate, installStartDate: i.installStartDate, installEndDate: i.installEndDate, processStartDate: i.processStartDate, processEndDate: i.processEndDate, shippedStartDate: i.shippedStartDate, shippedEndDate: i.shippedEndDate }), i;
      })) || [];
      const { addMonomerList: p, addAreaObj: r, modifyObj: s, lumpSumSystemType: u } = ye.get(`PROJECT_PLAN_${x.projectInfo.id}_DRAFT`) || {};
      if (D(p)) for (let i = 0; i < p.length; i++) d.value.push(p[i]);
      D(u) && (m.value = u), V(d.value, { addAreaObj: r, modifyObj: s });
    } catch (l) {
      console.log("获取单体区域列表失败", l);
    } finally {
      j.value = false;
    }
  }
  function V(t, { addAreaObj: n = {}, modifyObj: a = {} } = {}) {
    t.forEach((e, l) => {
      var p;
      D(a[`m_${e.id}`]) && Object.assign(e, a[`m_${e.id}`]), D(n[e.id]) && (e.areaList = e.areaList.concat(n[e.id])), e.trigger && e.trigger(), e.isMonomer = true, e.idx = l + 1, e = U(e), (p = e == null ? void 0 : e.areaList) == null || p.forEach((r, s) => {
        D(a[`a_${r.id}`]) && Object.assign(r, a[`a_${r.id}`]), r.trigger && r.trigger(), r.isMonomer = false, r.idx = e.idx + "." + (s + 1), r = U(r), B(r, e);
      }), e.trigger = Y(() => {
        var r;
        e.startDate = void 0, e.endDate = void 0, e.deepenStartDate = void 0, e.deepenEndDate = void 0, e.purchaseStartDate = void 0, e.purchaseEndDate = void 0, e.installStartDate = void 0, e.installEndDate = void 0, e.processStartDate = void 0, e.processEndDate = void 0, e.shippedStartDate = void 0, e.shippedEndDate = void 0, e.canDel = true, (r = e.areaList) == null || r.forEach((s) => {
          s.operateType !== "del" && (e.canDel = false, e.startDate = !e.startDate || s.startDate < e.startDate ? s.startDate : e.startDate, e.endDate = !e.endDate || s.endDate > e.endDate ? s.endDate : e.endDate, e.deepenStartDate = !e.deepenStartDate || s.deepenStartDate < e.deepenStartDate ? s.deepenStartDate : e.deepenStartDate, e.deepenEndDate = !e.deepenEndDate || s.deepenEndDate > e.deepenEndDate ? s.deepenEndDate : e.deepenEndDate, e.purchaseStartDate = !e.purchaseStartDate || s.purchaseStartDate < e.purchaseStartDate ? s.purchaseStartDate : e.purchaseStartDate, e.purchaseEndDate = !e.purchaseEndDate || s.purchaseEndDate > e.purchaseEndDate ? s.purchaseEndDate : e.purchaseEndDate, e.installStartDate = !e.installStartDate || s.installStartDate < e.installStartDate ? s.installStartDate : e.installStartDate, e.installEndDate = !e.installEndDate || s.installEndDate > e.installEndDate ? s.installEndDate : e.installEndDate, e.processStartDate = !e.processStartDate || s.processStartDate < e.processStartDate ? s.processStartDate : e.processStartDate, e.processEndDate = !e.processEndDate || s.processEndDate > e.processEndDate ? s.processEndDate : e.processEndDate, e.shippedStartDate = !e.shippedStartDate || s.shippedStartDate < e.shippedStartDate ? s.shippedStartDate : e.shippedStartDate, e.shippedEndDate = !e.shippedEndDate || s.shippedEndDate > e.shippedEndDate ? s.shippedEndDate : e.shippedEndDate, e.deepenTimes = e.deepenStartDate && e.deepenEndDate ? [Number(e.deepenStartDate), Number(e.deepenEndDate)] : [], e.purchaseTimes = e.purchaseStartDate && e.purchaseEndDate ? [Number(e.purchaseStartDate), Number(e.purchaseEndDate)] : [], e.installTimes = e.installStartDate && e.installEndDate ? [Number(e.installStartDate), Number(e.installEndDate)] : [], e.shippingTimes = e.shippedStartDate && e.shippedEndDate ? [Number(e.shippedStartDate), Number(e.shippedEndDate)] : [], e.processTimes = e.processStartDate && e.processEndDate ? [Number(e.processStartDate), Number(e.processEndDate)] : []);
        }), e.id || (e.operateType = "add");
      });
    });
  }
  const L = o(true);
  function B(t, n) {
    L.value = d.value.some((a) => {
      var e;
      return !(((e = a.areaList) == null ? void 0 : e.length) > 0);
    }), t.trigger = Y(() => {
      var l, p, r, s, u, i, g, h, F, $;
      console.log("areaRowWatch", t), t.deepenStartDate = (l = t.deepenTimes) == null ? void 0 : l[0], t.deepenEndDate = (p = t.deepenTimes) == null ? void 0 : p[1], t.purchaseStartDate = (r = t.purchaseTimes) == null ? void 0 : r[0], t.purchaseEndDate = (s = t.purchaseTimes) == null ? void 0 : s[1], t.installStartDate = (u = t.installTimes) == null ? void 0 : u[0], t.installEndDate = (i = t.installTimes) == null ? void 0 : i[1], t.processStartDate = (g = t.processTimes) == null ? void 0 : g[0], t.processEndDate = (h = t.processTimes) == null ? void 0 : h[1], t.shippedStartDate = (F = t.shippingTimes) == null ? void 0 : F[0], t.shippedEndDate = ($ = t.shippingTimes) == null ? void 0 : $[1];
      const a = [t.deepenStartDate, t.purchaseStartDate, t.installStartDate, t.processStartDate, t.shippedStartDate].filter((C) => !!C);
      t.startDate = a.length ? Math.min(...a) : void 0;
      const e = [t.deepenEndDate, t.purchaseEndDate, t.installEndDate, t.processEndDate, t.shippedEndDate].filter((C) => !!C);
      t.endDate = e.length ? Math.max(...e) : void 0, n.operateType === "del" ? t.canUnDel = false : t.canUnDel = true, t.id || (t.operateType = "add");
    });
  }
  function U(t) {
    return t.uid = t.uid ? t.uid : be(), t.startDate = Number(t.startDate), t.endDate = Number(t.endDate), t.deepenTimes = D(t.deepenTimes) ? t.deepenTimes : t.deepenStartDate && t.deepenEndDate ? [Number(t.deepenStartDate), Number(t.deepenEndDate)] : [], t.purchaseTimes = D(t.purchaseTimes) ? t.purchaseTimes : t.purchaseStartDate && t.purchaseEndDate ? [Number(t.purchaseStartDate), Number(t.purchaseEndDate)] : [], t.installTimes = D(t.installTimes) ? t.installTimes : t.installStartDate && t.installEndDate ? [Number(t.installStartDate), Number(t.installEndDate)] : [], t.processTimes = D(t.processTimes) ? t.processTimes : t.processStartDate && t.processEndDate ? [Number(t.processStartDate), Number(t.processEndDate)] : [], t.shippingTimes = D(t.shippingTimes) ? t.shippingTimes : t.shippedStartDate && t.shippedEndDate ? [Number(t.shippedStartDate), Number(t.shippedEndDate)] : [], pe(t);
  }
  function te(t) {
    N.value = t, O.value = true;
  }
  function ae(t) {
    N.value.name = t.name, N.value.remark = t.remark;
  }
  function se(t) {
    d.value.push({ ...t, isMonomer: true, isEdit: true, areaList: [] }), V(d.value);
  }
  function ne(t, n) {
    if (ue(() => {
      L.value = d.value.some((a) => {
        var e;
        return !(((e = a.areaList) == null ? void 0 : e.length) > 0);
      });
    }), t.isMonomer) {
      const a = d.value.findIndex((e) => t.idx === e.idx);
      d.value.splice(a, 1), V(d.value);
    } else {
      const a = t.idx.split("."), e = a[0], l = a[1];
      d.value[e - 1].areaList.splice(Number(l) - 1, 1), d.value[e - 1].areaList.forEach((p, r) => {
        p.idx = e + "." + (r + 1);
      });
    }
  }
  function ie(t) {
    var n;
    if (t.isMonomer) {
      if (((n = t.areaList) == null ? void 0 : n.length) > 0) {
        De({ message: "单体下存在区域，请先删除区域！", type: "error" });
        return;
      }
      t.operateType = "del", L.value = d.value.some((a) => {
        var e;
        return !(((e = a.areaList) == null ? void 0 : e.length) > 0) && t.operateType !== "del";
      }), S.value.push(t.id);
    } else {
      const a = t.idx.split("."), e = a[0], l = a[1];
      d.value[e - 1].areaList[l - 1].operateType = "del", T.value.push(t.id);
    }
  }
  function re(t) {
    if (t.isMonomer) {
      t.operateType = void 0;
      const n = S.value.findIndex((a) => t.id === a);
      S.value.splice(n, 1), L.value = d.value.some((a) => {
        var e;
        return !(((e = a.areaList) == null ? void 0 : e.length) > 0) && t.operateType !== "del";
      });
    } else {
      const n = t.idx.split("."), a = n[0], e = n[1];
      d.value[a - 1].areaList[e - 1].operateType = void 0;
      const l = T.value.findIndex((p) => t.id === p);
      T.value.splice(l, 1);
    }
  }
  function de() {
    S.value = [], T.value = [];
  }
  return (t, n) => {
    const a = fe, e = q("common-select"), l = he, p = me, r = q("common-drawer");
    return y(), I(r, { modelValue: c(R), "onUpdate:modelValue": n[2] || (n[2] = (s) => ce(R) ? R.value = s : null), "before-close": c(X), "close-on-click-modal": false, title: "项目计划详情", "wrapper-closable": false, "append-to-body": "", "custom-class": "project-plan-container-drawer", size: "100%" }, { titleAfter: E(() => {
      var s;
      return [M(a, { effect: "plain", size: "large", style: { "margin-right": "20px" } }, { default: E(() => {
        var u;
        return [b("span", null, _(f.projectInfo.projectSerialNumber + "-" + f.projectInfo.projectShortName), 1), n[3] || (n[3] = b("span", { style: { margin: "0 10px" } }, " | ", -1)), (u = f.projectInfo) != null && u.orderType ? (y(), oe("span", Le, _(f.projectInfo.orderType || "-"), 1)) : G("", true), n[4] || (n[4] = b("span", { style: { margin: "0 10px" } }, " | ", -1)), b("span", Ie, " 开工日期：" + _(c(J)(f.projectInfo.startDate, "{y}-{m}-{d}") || "-") + " ~ 完工日期：" + _(c(J)(f.projectInfo.endDate, "{y}-{m}-{d}") || "-"), 1), b("span", Me, "工期：" + _(f.projectInfo.duration || "-") + "天", 1)];
      }), _: 1, __: [3, 4] }), ((s = f.projectInfo) == null ? void 0 : s.projectAttribute) === c(_e).LUMP_SUM_SYSTEM.V ? (y(), I(p, { key: 0 }, { default: E(() => [M(l, { class: "form-label-require", label: "内包制项目管理选项", style: { "margin-bottom": "0" } }, { default: E(() => [M(e, { modelValue: m.value, "onUpdate:modelValue": n[0] || (n[0] = (u) => m.value = u), disabled: !k.value, options: c(v).ENUM, unshowOptions: [c(v).OTHER.K], class: "filter-item", clearable: "", placeholder: "请选择管理选项", style: { width: "300px" }, type: "enum", onChange: Z }, null, 8, ["modelValue", "disabled", "options", "unshowOptions"])]), _: 1 })]), _: 1 })) : G("", true)];
    }), titleRight: E(() => n[5] || (n[5] = [])), content: E(() => [P.value === 1 ? (y(), I(c(xe), { key: 0, ref_key: "tableRef", ref: H, fetchMonomerLoading: j.value, maxHeight: c(A) - 43, monomerList: d.value, onAreaRowWatch: B, onDelRow: ne, onToEditMonomer: te, onUndelete: re, onVirtualDelRow: ie }, null, 8, ["fetchMonomerLoading", "maxHeight", "monomerList"])) : (y(), I(Ne, { key: 1, ref_key: "tableRef", ref: H, maxHeight: c(A), monomerList: d.value }, null, 8, ["maxHeight", "monomerList"])), M(c(ve), { visible: O.value, "onUpdate:visible": n[1] || (n[1] = (s) => O.value = s), info: N.value, onAdd: se, onEdit: ae }, null, 8, ["visible", "info"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ae = Ee(Re, [["__scopeId", "data-v-6af66b45"]]);
export {
  Ae as default
};
