import { provide as ae } from "vue";
import { computed as ye } from "vue";
import { ref as u } from "vue";
import { watchEffect as se } from "vue";
import { reactive as ve } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as I } from "vue";
import { withCtx as f } from "vue";
import { createVNode as x } from "vue";
import { createElementVNode as k } from "vue";
import { toDisplayString as C } from "vue";
import { createElementBlock as Te } from "vue";
import { createCommentVNode as M } from "vue";
import { unref as h } from "vue";
import { withModifiers as V } from "vue";
import { createTextVNode as O } from "vue";
import { withDirectives as _e } from "vue";
import { vShow as be } from "vue";
import { isRef as Ie } from "vue";
import { nextTick as xe } from "vue";
import { ElMessage as W } from "element-plus";
import { ElTag as je } from "element-plus";
import { ElFormItem as Le } from "element-plus";
import { ElForm as Ne } from "element-plus";
import { ElStep as Me } from "element-plus";
import { ElSteps as Re } from "element-plus";
import { g as ke, d as ne } from "../../../../modules/sectional-entry-plan-49cfc1e2.js";
import { _ as Ce, u as Ve, o as Oe, V as J, cM as Pe, i as y, aI as Ae, p as ie, gD as ze, mv as P } from "../../../../shared/runtime.js";
import Be from "./custom-monomer-form.vue.js";
import He from "./subitemType-plan-table.vue.js";
import Ue from "./create-dept-plan.vue.js";
const Fe = { key: 0, style: { color: "#e6a23c" } }, $e = { style: { color: "#67c23a" } }, qe = { style: { color: "#67c23a", "margin-left": "10px" } }, Ye = { __name: "create-project", props: { modelValue: { type: Boolean, require: true }, projectInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(v, { emit: re }) {
  const D = v;
  ae("projectInfo", ye(() => D.projectInfo));
  const K = re, { visible: z, handleClose: Q } = Ve({ emit: K, props: D, showHook: de, closeHook: ge }), { maxHeight: X } = Oe({ mainBox: ".project-plan-container-drawer", extraBox: [".el-drawer__header", ".project-plan-steps"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }), B = u(), d = u(), S = u(1), b = u(), H = u(false), U = u(false), j = u([]), L = u([]), F = u(false), A = u(false), R = u({}), $ = u(false);
  ae("lumpSumSystemType", b);
  const le = (t) => {
    console.log(t), d.value.forEach((s) => {
      s.areaList.forEach((a) => {
        t === P.NO_FACTORY_PROCESSING_NEED_CONTROL.V ? (a.shippingTimes = [], a.deepenTimes = [], a.purchaseTimes = [], a.processTimes = []) : t === P.NO_FACTORY_PROCESSING_NO_CONTROL.V ? (a.shippingTimes = [], a.deepenTimes = [], a.purchaseTimes = [], a.processTimes = [], a.installTimes = []) : t === P.NEED_FACTORY_PROCESSING_NO_CONTROL.V && (a.installTimes = []);
      });
    });
  };
  function de() {
    S.value = 1, b.value = void 0, Z();
  }
  async function Z() {
    var t, s, a, e;
    U.value = true;
    try {
      d.value = [], j.value = [], L.value = [];
      const o = await ke((t = D.projectInfo) == null ? void 0 : t.projectId);
      b.value = (s = o.monomerList) == null ? void 0 : s.lumpSumSystemType, ((a = o.monomerList) == null ? void 0 : a.length) === 0 ? $.value = true : $.value = false, d.value = ((e = o.monomerList) == null ? void 0 : e.map((l) => {
        var c;
        return b.value = l.lumpSumSystemType, (c = l.areaList) == null || c.forEach((i) => {
          i.deliveryStartDate && i.deliveryEndDate ? i.deliveryDate = [i.deliveryStartDate, i.deliveryEndDate] : i.deliveryDate = null;
        }), l.sourceRow = J({ name: l.name, itemizedType: l.itemizedType, mete: l.mete, remark: l.remark, type: l.type }), l.sourcePlanRow = J({ startDate: l.startDate, endDate: l.endDate, deepenStartDate: l.deepenStartDate, deepenEndDate: l.deepenEndDate, purchaseStartDate: l.purchaseStartDate, purchaseEndDate: l.purchaseEndDate, installStartDate: l.installStartDate, installEndDate: l.installEndDate, processStartDate: l.processStartDate, processEndDate: l.processEndDate, shippedStartDate: l.shippedStartDate, shippedEndDate: l.shippedEndDate }), l;
      })) || [];
      const { addMonomerList: p, addAreaObj: r, modifyObj: n, lumpSumSystemType: T } = Pe.get(`PROJECT_PLAN_${D.projectInfo.id}_DRAFT`) || {};
      if (y(p)) for (let l = 0; l < p.length; l++) d.value.push(p[l]);
      y(T) && (b.value = T), q(d.value, { addAreaObj: r, modifyObj: n });
    } catch (o) {
      console.log("获取单体区域列表失败", o);
    } finally {
      U.value = false;
    }
  }
  function q(t, { addAreaObj: s = {}, modifyObj: a = {} } = {}) {
    t.forEach((e, o) => {
      var p;
      y(a[`m_${e.id}`]) && Object.assign(e, a[`m_${e.id}`]), y(s[e.id]) && (e.areaList = e.areaList.concat(s[e.id])), e.trigger && e.trigger(), e.isMonomer = true, e.idx = o + 1, e = ee(e), (p = e == null ? void 0 : e.areaList) == null || p.forEach((r, n) => {
        y(a[`a_${r.id}`]) && Object.assign(r, a[`a_${r.id}`]), r.trigger && r.trigger(), r.isMonomer = false, r.idx = e.idx + "." + (n + 1), r = ee(r), w(r, e);
      }), e.trigger = se(() => {
        var r;
        e.startDate = void 0, e.endDate = void 0, e.deepenStartDate = void 0, e.deepenEndDate = void 0, e.purchaseStartDate = void 0, e.purchaseEndDate = void 0, e.installStartDate = void 0, e.installEndDate = void 0, e.processStartDate = void 0, e.processEndDate = void 0, e.shippedStartDate = void 0, e.shippedEndDate = void 0, e.canDel = true, (r = e.areaList) == null || r.forEach((n) => {
          n.operateType !== "del" && (e.canDel = false, e.startDate = !e.startDate || n.startDate < e.startDate ? n.startDate : e.startDate, e.endDate = !e.endDate || n.endDate > e.endDate ? n.endDate : e.endDate, e.deepenStartDate = !e.deepenStartDate || n.deepenStartDate < e.deepenStartDate ? n.deepenStartDate : e.deepenStartDate, e.deepenEndDate = !e.deepenEndDate || n.deepenEndDate > e.deepenEndDate ? n.deepenEndDate : e.deepenEndDate, e.purchaseStartDate = !e.purchaseStartDate || n.purchaseStartDate < e.purchaseStartDate ? n.purchaseStartDate : e.purchaseStartDate, e.purchaseEndDate = !e.purchaseEndDate || n.purchaseEndDate > e.purchaseEndDate ? n.purchaseEndDate : e.purchaseEndDate, e.installStartDate = !e.installStartDate || n.installStartDate < e.installStartDate ? n.installStartDate : e.installStartDate, e.installEndDate = !e.installEndDate || n.installEndDate > e.installEndDate ? n.installEndDate : e.installEndDate, e.processStartDate = !e.processStartDate || n.processStartDate < e.processStartDate ? n.processStartDate : e.processStartDate, e.processEndDate = !e.processEndDate || n.processEndDate > e.processEndDate ? n.processEndDate : e.processEndDate, e.shippedStartDate = !e.shippedStartDate || n.shippedStartDate < e.shippedStartDate ? n.shippedStartDate : e.shippedStartDate, e.shippedEndDate = !e.shippedEndDate || n.shippedEndDate > e.shippedEndDate ? n.shippedEndDate : e.shippedEndDate, e.deepenTimes = e.deepenStartDate && e.deepenEndDate ? [Number(e.deepenStartDate), Number(e.deepenEndDate)] : [], e.purchaseTimes = e.purchaseStartDate && e.purchaseEndDate ? [Number(e.purchaseStartDate), Number(e.purchaseEndDate)] : [], e.installTimes = e.installStartDate && e.installEndDate ? [Number(e.installStartDate), Number(e.installEndDate)] : [], e.shippingTimes = e.shippedStartDate && e.shippedEndDate ? [Number(e.shippedStartDate), Number(e.shippedEndDate)] : [], e.processTimes = e.processStartDate && e.processEndDate ? [Number(e.processStartDate), Number(e.processEndDate)] : []);
        }), e.id || (e.operateType = "add");
      });
    });
  }
  const N = u(true);
  function w(t, s) {
    N.value = d.value.some((a) => {
      var e;
      return !(((e = a.areaList) == null ? void 0 : e.length) > 0);
    }), t.trigger = se(() => {
      var o, p, r, n, T, l, c, i, E, g;
      console.log("areaRowWatch", t), t.deepenStartDate = (o = t.deepenTimes) == null ? void 0 : o[0], t.deepenEndDate = (p = t.deepenTimes) == null ? void 0 : p[1], t.purchaseStartDate = (r = t.purchaseTimes) == null ? void 0 : r[0], t.purchaseEndDate = (n = t.purchaseTimes) == null ? void 0 : n[1], t.installStartDate = (T = t.installTimes) == null ? void 0 : T[0], t.installEndDate = (l = t.installTimes) == null ? void 0 : l[1], t.processStartDate = (c = t.processTimes) == null ? void 0 : c[0], t.processEndDate = (i = t.processTimes) == null ? void 0 : i[1], t.shippedStartDate = (E = t.shippingTimes) == null ? void 0 : E[0], t.shippedEndDate = (g = t.shippingTimes) == null ? void 0 : g[1];
      const a = [t.deepenStartDate, t.purchaseStartDate, t.installStartDate, t.processStartDate, t.shippedStartDate].filter((m) => !!m);
      t.startDate = a.length ? Math.min(...a) : void 0;
      const e = [t.deepenEndDate, t.purchaseEndDate, t.installEndDate, t.processEndDate, t.shippedEndDate].filter((m) => !!m);
      t.endDate = e.length ? Math.max(...e) : void 0, s.operateType === "del" ? t.canUnDel = false : t.canUnDel = true, t.id || (t.operateType = "add");
    });
  }
  function ee(t) {
    return t.uid = t.uid ? t.uid : Ae(), t.startDate = Number(t.startDate), t.endDate = Number(t.endDate), t.deepenTimes = y(t.deepenTimes) ? t.deepenTimes : t.deepenStartDate && t.deepenEndDate ? [Number(t.deepenStartDate), Number(t.deepenEndDate)] : [], t.purchaseTimes = y(t.purchaseTimes) ? t.purchaseTimes : t.purchaseStartDate && t.purchaseEndDate ? [Number(t.purchaseStartDate), Number(t.purchaseEndDate)] : [], t.installTimes = y(t.installTimes) ? t.installTimes : t.installStartDate && t.installEndDate ? [Number(t.installStartDate), Number(t.installEndDate)] : [], t.processTimes = y(t.processTimes) ? t.processTimes : t.processStartDate && t.processEndDate ? [Number(t.processStartDate), Number(t.processEndDate)] : [], t.shippingTimes = y(t.shippingTimes) ? t.shippingTimes : t.shippedStartDate && t.shippedEndDate ? [Number(t.shippedStartDate), Number(t.shippedEndDate)] : [], ve(t);
  }
  function oe() {
    R.value = {}, A.value = true;
  }
  function pe(t) {
    R.value = t, A.value = true;
  }
  function ce(t) {
    R.value.name = t.name, R.value.remark = t.remark;
  }
  function ue(t) {
    d.value.push({ ...t, isMonomer: true, isEdit: true, areaList: [] }), q(d.value);
  }
  function De(t, s) {
    if (xe(() => {
      N.value = d.value.some((a) => {
        var e;
        return !(((e = a.areaList) == null ? void 0 : e.length) > 0);
      });
    }), t.isMonomer) {
      const a = d.value.findIndex((e) => t.idx === e.idx);
      d.value.splice(a, 1), q(d.value);
    } else {
      const a = t.idx.split("."), e = a[0], o = a[1];
      d.value[e - 1].areaList.splice(Number(o) - 1, 1), d.value[e - 1].areaList.forEach((p, r) => {
        p.idx = e + "." + (r + 1);
      });
    }
  }
  function fe(t) {
    var s;
    if (t.isMonomer) {
      if (((s = t.areaList) == null ? void 0 : s.length) > 0) {
        W({ message: "单体下存在区域，请先删除区域！", type: "error" });
        return;
      }
      t.operateType = "del", N.value = d.value.some((a) => {
        var e;
        return !(((e = a.areaList) == null ? void 0 : e.length) > 0) && t.operateType !== "del";
      }), j.value.push(t.id);
    } else {
      const a = t.idx.split("."), e = a[0], o = a[1];
      d.value[e - 1].areaList[o - 1].operateType = "del", L.value.push(t.id);
    }
  }
  function me(t) {
    if (t.isMonomer) {
      t.operateType = void 0;
      const s = j.value.findIndex((a) => t.id === a);
      j.value.splice(s, 1), N.value = d.value.some((a) => {
        var e;
        return !(((e = a.areaList) == null ? void 0 : e.length) > 0) && t.operateType !== "del";
      });
    } else {
      const s = t.idx.split("."), a = s[0], e = s[1];
      d.value[a - 1].areaList[e - 1].operateType = void 0;
      const o = L.value.findIndex((p) => t.id === p);
      L.value.splice(o, 1);
    }
  }
  function he() {
    const { flag: t } = Y();
    t && S.value++;
  }
  function Y() {
    var a;
    const t = [];
    if (d.value.filter((e) => e.operateType !== "del").forEach((e) => {
      var p, r;
      e.projectId = (p = D.projectInfo) == null ? void 0 : p.id;
      const o = ((r = e.areaList) == null ? void 0 : r.filter((n) => n.operateType !== "del")) || [];
      t.push(...o);
    }), t != null && t.length) {
      const { validResult: e } = (a = B.value) == null ? void 0 : a.tableValidate(t);
      if (!e) return { flag: false };
    }
    return { flag: true };
  }
  async function Se() {
    var s, a;
    const { flag: t } = Y();
    if (t) try {
      H.value = true;
      const e = J(d.value);
      console.log(e);
      const o = [], p = [], r = [], n = [], T = [];
      for (let c = 0; c < e.length; c++) {
        const i = e[c];
        console.log(D.projectInfo), i.projectId = (s = D.projectInfo) == null ? void 0 : s.id;
        const E = [];
        i.lumpSumSystemType = b.value;
        for (let g = 0; g < i.areaList.length; g++) {
          const m = i.areaList[g];
          m.projectId = (a = D.projectInfo) == null ? void 0 : a.id, m.monomerId = i == null ? void 0 : i.id, m.operateType === "add" ? E.push(m) : m.operateType === "del" ? r.push(m) : te(i) && T.push(m);
        }
        i.operateType === "add" || E != null && E.length ? o.push(i) : i.operateType === "del" ? p.push(i) : te(i) && n.push(i);
      }
      d.value.forEach((c) => {
        var i;
        c.projectId = (i = D.projectInfo) == null ? void 0 : i.projectId, c.areaList.forEach((E) => {
          var g;
          E.projectId = (g = D.projectInfo) == null ? void 0 : g.projectId;
        });
      });
      const l = { monomerSaveParams: d.value, removeMonomerIds: j.value, removeAreaIds: L.value };
      await ne(l), W({ message: "保存成功", type: "success" }), Q(), K("success");
    } catch (e) {
      console.log("保存失败", e);
    } finally {
      H.value = false;
    }
  }
  function te(t) {
    const s = t.sourceRow, a = t.sourcePlanRow;
    return t.id !== s.id || t.remark !== s.remark || t.mete !== s.mete || t.type !== s.type || t.itemizedType !== s.itemizedType || t.startDate !== a.startDate || t.endDate !== a.endDate || t.deepenStartDate !== a.deepenStartDate || t.deepenEndDate !== a.deepenEndDate || t.purchaseStartDate !== a.purchaseStartDate || t.purchaseEndDate !== a.purchaseEndDate || t.installStartDate !== a.installStartDate || t.installEndDate !== a.installEndDate || t.processStartDate !== a.processStartDate || t.processEndDate !== a.processEndDate || t.shippedStartDate !== a.shippedStartDate || t.shippedEndDate !== a.shippedEndDate;
  }
  async function Ee() {
    const { flag: t } = Y();
    if (t) {
      F.value = true;
      try {
        d.value.forEach((a) => {
          var e, o;
          a.projectId = (e = D.projectInfo) == null ? void 0 : e.projectId, (o = a.areaList) == null || o.forEach((p) => {
            var r;
            p.projectId = (r = D.projectInfo) == null ? void 0 : r.projectId;
          });
        });
        const s = { monomerSaveParams: d.value, removeMonomerIds: j.value, removeAreaIds: L.value };
        await ne(s), Z(), W({ message: "暂存成功", type: "success" });
      } catch (s) {
        console.log(s);
      } finally {
        F.value = false;
      }
    }
  }
  function ge() {
    j.value = [], L.value = [];
  }
  return (t, s) => {
    const a = je, e = G("common-select"), o = Le, p = Ne, r = G("common-button"), n = Me, T = Re, l = G("common-drawer");
    return _(), I(l, { "append-to-body": "", "close-on-click-modal": false, "before-close": h(Q), modelValue: h(z), "onUpdate:modelValue": s[3] || (s[3] = (c) => Ie(z) ? z.value = c : null), title: "创建项目计划", "custom-class": "project-plan-container-drawer", "wrapper-closable": false, size: "100%" }, { titleAfter: f(() => {
      var c;
      return [x(a, { size: "large", effect: "plain", style: { "margin-right": "20px" } }, { default: f(() => {
        var i;
        return [k("span", null, C(v.projectInfo.projectSerialNumber + "-" + v.projectInfo.projectShortName), 1), s[4] || (s[4] = k("span", { style: { margin: "0 10px" } }, " | ", -1)), (i = v.projectInfo) != null && i.orderType ? (_(), Te("span", Fe, C(v.projectInfo.orderType || "-"), 1)) : M("", true), s[5] || (s[5] = k("span", { style: { margin: "0 10px" } }, " | ", -1)), k("span", $e, " 开工日期：" + C(h(ie)(v.projectInfo.startDate, "{y}-{m}-{d}") || "-") + " ~ 完工日期：" + C(h(ie)(v.projectInfo.endDate, "{y}-{m}-{d}") || "-"), 1), k("span", qe, "工期：" + C(v.projectInfo.duration || "-") + "天", 1)];
      }), _: 1, __: [4, 5] }), ((c = v.projectInfo) == null ? void 0 : c.projectAttribute) === h(ze).LUMP_SUM_SYSTEM.V ? (_(), I(p, { key: 0 }, { default: f(() => [x(o, { label: "内包制项目管理选项", class: "form-label-require", style: { "margin-bottom": "0" } }, { default: f(() => [x(e, { modelValue: b.value, "onUpdate:modelValue": s[0] || (s[0] = (i) => b.value = i), options: h(P).ENUM, type: "enum", disabled: !$.value, unshowOptions: [h(P).OTHER.K], class: "filter-item", clearable: "", style: { width: "300px" }, placeholder: "请选择管理选项", onChange: le }, null, 8, ["modelValue", "options", "disabled", "unshowOptions"])]), _: 1 })]), _: 1 })) : M("", true)];
    }), titleRight: f(() => {
      var c, i;
      return [S.value === 2 ? (_(), I(r, { key: 0, size: "default", type: "warning", style: { float: "right" }, onClick: s[1] || (s[1] = V((E) => S.value--, ["stop"])) }, { default: f(() => s[6] || (s[6] = [O(" 上一步 ")])), _: 1, __: [6] })) : M("", true), S.value === 1 ? (_(), I(r, { key: 1, type: "primary", size: "default", style: { float: "right" }, disabled: N.value, onClick: V(he, ["stop"]) }, { default: f(() => s[7] || (s[7] = [O(" 下一步 ")])), _: 1, __: [7] }, 8, ["disabled"])) : M("", true), S.value === 1 ? (_(), I(r, { key: 2, size: "default", type: "warning", disabled: !((c = d.value) != null && c.length) || N.value, loading: F.value, onClick: V(Ee, ["stop"]) }, { default: f(() => s[8] || (s[8] = [O(" 暂存 ")])), _: 1, __: [8] }, 8, ["disabled", "loading"])) : M("", true), S.value === 2 ? (_(), I(r, { key: 3, loading: H.value, size: "default", type: "success", disabled: !((i = d.value) != null && i.length), onClick: V(Se, ["stop"]) }, { default: f(() => s[9] || (s[9] = [O(" 保存 ")])), _: 1, __: [9] }, 8, ["loading", "disabled"])) : M("", true)];
    }), content: f(() => [x(T, { class: "project-plan-steps", active: S.value, simple: "", style: { "margin-bottom": "8px", width: "900px" } }, { default: f(() => [x(n, { title: "创建单体区域计划" }), x(n, { title: "创建部门计划" })]), _: 1 }, 8, ["active"]), _e(x(r, { type: "primary", icon: "el-icon-plus", style: { "margin-bottom": "10px" }, onClick: V(oe, ["stop"]) }, { default: f(() => s[10] || (s[10] = [O(" 创建单体 ")])), _: 1, __: [10] }, 512), [[be, S.value === 1]]), S.value === 1 ? (_(), I(h(He), { key: 0, ref_key: "tableRef", ref: B, monomerList: d.value, fetchMonomerLoading: U.value, maxHeight: h(X) - 43, onToEditMonomer: pe, onAreaRowWatch: w, onDelRow: De, onVirtualDelRow: fe, onUndelete: me }, null, 8, ["monomerList", "fetchMonomerLoading", "maxHeight"])) : (_(), I(Ue, { key: 1, ref_key: "tableRef", ref: B, monomerList: d.value, maxHeight: h(X) }, null, 8, ["monomerList", "maxHeight"])), x(h(Be), { visible: A.value, "onUpdate:visible": s[2] || (s[2] = (c) => A.value = c), info: R.value, onAdd: ue, onEdit: ce }, null, 8, ["visible", "info"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, we = Ce(Ye, [["__scopeId", "data-v-11d14aa8"]]);
export {
  we as default
};
