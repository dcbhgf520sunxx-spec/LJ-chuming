import { provide as Z } from "vue";
import { computed as Ee } from "vue";
import { ref as T } from "vue";
import { watchEffect as w } from "vue";
import { reactive as Se } from "vue";
import { resolveComponent as H } from "vue";
import { resolveDirective as ye } from "vue";
import { openBlock as g } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as m } from "vue";
import { createVNode as v } from "vue";
import { createElementBlock as ee } from "vue";
import { Fragment as te } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as L } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as I } from "vue";
import { withModifiers as M } from "vue";
import { createTextVNode as O } from "vue";
import { withDirectives as Te } from "vue";
import { vShow as be } from "vue";
import { isRef as _e } from "vue";
import { ElNotification as ve } from "element-plus";
import { ElMessage as Ne } from "element-plus";
import { ElTag as xe } from "element-plus";
import { ElFormItem as je } from "element-plus";
import { ElForm as Le } from "element-plus";
import { ElStep as Ie } from "element-plus";
import { ElSteps as Re } from "element-plus";
import { a as Me, s as Oe } from "../../../../../modules/project-plan-a5233e17.js";
import { _ as Ce, u as Ve, o as ke, V as C, cM as U, i as E, aI as Ae, gD as ae, bN as Pe, p as se, c7 as ze, mv as V } from "../../../../../shared/runtime.js";
import { j as Be } from "../../../../../modules/plan-d12d7ccf.js";
import Fe from "./custom-monomer-form.vue.js";
import $e from "./subitemType-plan-table.vue.js";
import He from "./create-dept-plan.vue.js";
const Ue = { style: { color: "#529b2e" } }, qe = { style: { color: "#e6a23c" } }, Ye = { style: { "margin-left": "10px" } }, Ge = { __name: "create-project", props: { modelValue: { type: Boolean, require: true }, projectInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(f, { emit: ne }) {
  const h = f;
  Z("projectInfo", Ee(() => h.projectInfo));
  const q = ne, { visible: A, handleClose: Y } = Ve({ emit: q, props: h, showHook: re }), { maxHeight: G } = ke({ mainBox: ".project-plan-container-drawer", extraBox: [".el-drawer__header", ".project-plan-steps"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }), P = T(), p = T(), S = T(1), y = T(), z = T(false), k = T(false), R = T({}), B = T(false);
  Z("lumpSumSystemType", y);
  const ie = (t) => {
    console.log(t), p.value.forEach((n) => {
      n.areaList.forEach((s) => {
        t === V.NO_FACTORY_PROCESSING_NEED_CONTROL.V ? (s.shippingTimes = [], s.deepenTimes = [], s.purchaseTimes = [], s.processTimes = []) : t === V.NO_FACTORY_PROCESSING_NO_CONTROL.V ? (s.shippingTimes = [], s.deepenTimes = [], s.purchaseTimes = [], s.processTimes = [], s.installTimes = []) : t === V.NEED_FACTORY_PROCESSING_NO_CONTROL.V && (s.installTimes = []);
      });
    });
  };
  function re() {
    S.value = 1, y.value = void 0, pe();
  }
  async function pe() {
    var t;
    try {
      p.value = [];
      const { content: n } = await Me({ projectId: (t = h.projectInfo) == null ? void 0 : t.id });
      y.value = n.lumpSumSystemType, (n == null ? void 0 : n.length) === 0 ? B.value = true : B.value = false, p.value = (n == null ? void 0 : n.map((a) => (y.value = a.lumpSumSystemType, a.areaList = a.areaDTOList, a.sourceRow = C({ name: a.name, itemizedType: a.itemizedType, mete: a.mete, remark: a.remark, type: a.type }), a.sourcePlanRow = C({ startDate: a.startDate, endDate: a.endDate, deepenStartDate: a.deepenStartDate, deepenEndDate: a.deepenEndDate, purchaseStartDate: a.purchaseStartDate, purchaseEndDate: a.purchaseEndDate, installStartDate: a.installStartDate, installEndDate: a.installEndDate, processStartDate: a.processStartDate, processEndDate: a.processEndDate, shippingStartDate: a.shippingStartDate, shippingEndDate: a.shippingEndDate }), a))) || [];
      const { addMonomerList: s, addAreaObj: e, modifyObj: o, lumpSumSystemType: r } = U.get(`PROJECT_PLAN_${h.projectInfo.id}_DRAFT`) || {};
      if (E(s)) for (let a = 0; a < s.length; a++) p.value.push(s[a]);
      E(r) && (y.value = r), F(p.value, { addAreaObj: e, modifyObj: o });
    } catch (n) {
      console.log("获取单体区域列表失败", n);
    }
  }
  function F(t, { addAreaObj: n = {}, modifyObj: s = {} } = {}) {
    t.forEach((e, o) => {
      var r;
      E(s[`m_${e.id}`]) && Object.assign(e, s[`m_${e.id}`]), E(n[e.id]) && (e.areaList = e.areaList.concat(n[e.id])), e.trigger && e.trigger(), e.isMonomer = true, e.idx = o + 1, e = W(e), (r = e == null ? void 0 : e.areaList) == null || r.forEach((a, i) => {
        E(s[`a_${a.id}`]) && Object.assign(a, s[`a_${a.id}`]), a.trigger && a.trigger(), a.isMonomer = false, a.idx = e.idx + "." + (i + 1), a = W(a), J(a, e);
      }), e.trigger = w(() => {
        var a;
        e.startDate = void 0, e.endDate = void 0, e.deepenStartDate = void 0, e.deepenEndDate = void 0, e.purchaseStartDate = void 0, e.purchaseEndDate = void 0, e.installStartDate = void 0, e.installEndDate = void 0, e.processStartDate = void 0, e.processEndDate = void 0, e.shippingStartDate = void 0, e.shippingEndDate = void 0, e.canDel = true, (a = e.areaList) == null || a.forEach((i) => {
          i.operateType !== "del" && (e.canDel = false, e.startDate = !e.startDate || i.startDate < e.startDate ? i.startDate : e.startDate, e.endDate = !e.endDate || i.endDate > e.endDate ? i.endDate : e.endDate, e.deepenStartDate = !e.deepenStartDate || i.deepenStartDate < e.deepenStartDate ? i.deepenStartDate : e.deepenStartDate, e.deepenEndDate = !e.deepenEndDate || i.deepenEndDate > e.deepenEndDate ? i.deepenEndDate : e.deepenEndDate, e.purchaseStartDate = !e.purchaseStartDate || i.purchaseStartDate < e.purchaseStartDate ? i.purchaseStartDate : e.purchaseStartDate, e.purchaseEndDate = !e.purchaseEndDate || i.purchaseEndDate > e.purchaseEndDate ? i.purchaseEndDate : e.purchaseEndDate, e.installStartDate = !e.installStartDate || i.installStartDate < e.installStartDate ? i.installStartDate : e.installStartDate, e.installEndDate = !e.installEndDate || i.installEndDate > e.installEndDate ? i.installEndDate : e.installEndDate, e.processStartDate = !e.processStartDate || i.processStartDate < e.processStartDate ? i.processStartDate : e.processStartDate, e.processEndDate = !e.processEndDate || i.processEndDate > e.processEndDate ? i.processEndDate : e.processEndDate, e.shippingStartDate = !e.shippingStartDate || i.shippingStartDate < e.shippingStartDate ? i.shippingStartDate : e.shippingStartDate, e.shippingEndDate = !e.shippingEndDate || i.shippingEndDate > e.shippingEndDate ? i.shippingEndDate : e.shippingEndDate, e.deepenTimes = e.deepenStartDate && e.deepenEndDate ? [Number(e.deepenStartDate), Number(e.deepenEndDate)] : [], e.purchaseTimes = e.purchaseStartDate && e.purchaseEndDate ? [Number(e.purchaseStartDate), Number(e.purchaseEndDate)] : [], e.installTimes = e.installStartDate && e.installEndDate ? [Number(e.installStartDate), Number(e.installEndDate)] : [], e.shippingTimes = e.shippingStartDate && e.shippingEndDate ? [Number(e.shippingStartDate), Number(e.shippingEndDate)] : [], e.processTimes = e.processStartDate && e.processEndDate ? [Number(e.processStartDate), Number(e.processEndDate)] : []);
        }), e.id || (e.operateType = "add");
      });
    });
  }
  const $ = T(true);
  function J(t, n) {
    p.value.forEach((s) => {
      var e;
      ((e = s.areaList) == null ? void 0 : e.length) > 0 && ($.value = false);
    }), t.trigger = w(() => {
      var o, r, a, i, x, b, l, d, c, D;
      console.log("areaRowWatch", t), t.deepenStartDate = (o = t.deepenTimes) == null ? void 0 : o[0], t.deepenEndDate = (r = t.deepenTimes) == null ? void 0 : r[1], t.purchaseStartDate = (a = t.purchaseTimes) == null ? void 0 : a[0], t.purchaseEndDate = (i = t.purchaseTimes) == null ? void 0 : i[1], t.installStartDate = (x = t.installTimes) == null ? void 0 : x[0], t.installEndDate = (b = t.installTimes) == null ? void 0 : b[1], t.processStartDate = (l = t.processTimes) == null ? void 0 : l[0], t.processEndDate = (d = t.processTimes) == null ? void 0 : d[1], t.shippingStartDate = (c = t.shippingTimes) == null ? void 0 : c[0], t.shippingEndDate = (D = t.shippingTimes) == null ? void 0 : D[1];
      const s = [t.deepenStartDate, t.purchaseStartDate, t.installStartDate, t.processStartDate, t.shippingStartDate].filter((j) => !!j);
      t.startDate = s.length ? Math.min(...s) : void 0;
      const e = [t.deepenEndDate, t.purchaseEndDate, t.installEndDate, t.processEndDate, t.shippingEndDate].filter((j) => !!j);
      t.endDate = e.length ? Math.max(...e) : void 0, n.operateType === "del" ? t.canUnDel = false : t.canUnDel = true, t.id || (t.operateType = "add");
    });
  }
  function W(t) {
    return t.uid = t.uid ? t.uid : Ae(), t.startDate = Number(t.startDate), t.endDate = Number(t.endDate), t.deepenTimes = E(t.deepenTimes) ? t.deepenTimes : t.deepenStartDate && t.deepenEndDate ? [Number(t.deepenStartDate), Number(t.deepenEndDate)] : [], t.purchaseTimes = E(t.purchaseTimes) ? t.purchaseTimes : t.purchaseStartDate && t.purchaseEndDate ? [Number(t.purchaseStartDate), Number(t.purchaseEndDate)] : [], t.installTimes = E(t.installTimes) ? t.installTimes : t.installStartDate && t.installEndDate ? [Number(t.installStartDate), Number(t.installEndDate)] : [], t.processTimes = E(t.processTimes) ? t.processTimes : t.processStartDate && t.processEndDate ? [Number(t.processStartDate), Number(t.processEndDate)] : [], t.shippingTimes = E(t.shippingTimes) ? t.shippingTimes : t.shippingStartDate && t.shippingEndDate ? [Number(t.shippingStartDate), Number(t.shippingEndDate)] : [], Se(t);
  }
  function le() {
    R.value = {}, k.value = true;
  }
  function oe(t) {
    R.value = t, k.value = true;
  }
  function de(t) {
    R.value.name = t.name, R.value.remark = t.remark;
  }
  function ce(t) {
    p.value.push({ ...t, isMonomer: true, isEdit: true, areaList: [] }), F(p.value);
  }
  function ue(t, n) {
    if (p.value.forEach((s) => {
      console.log(s), s.areaList.length === 1 && ($.value = true);
    }), t.isMonomer) {
      const s = p.value.findIndex((e) => t.idx === e.idx);
      p.value.splice(s, 1), F(p.value);
    } else {
      const s = t.idx.split("."), e = s[0], o = s[1];
      p.value[e - 1].areaList.splice(Number(o) - 1, 1), p.value[e - 1].areaList.forEach((r, a) => {
        r.idx = e + "." + (a + 1);
      });
    }
  }
  function De(t) {
    if (console.log(t), t.isMonomer) t.operateType = "del";
    else {
      const n = t.idx.split("."), s = n[0], e = n[1];
      p.value[s - 1].areaList[e - 1].operateType = "del";
    }
  }
  function fe(t) {
    if (t.isMonomer) t.operateType = void 0;
    else {
      const n = t.idx.split("."), s = n[0], e = n[1];
      p.value[s - 1].areaList[e - 1].operateType = void 0;
    }
  }
  function me() {
    const { flag: t } = K();
    t && S.value++;
  }
  function K() {
    var s;
    const t = [];
    if (p.value.filter((e) => e.operateType !== "del").forEach((e) => {
      var r;
      e.projectId = (r = h.projectInfo) == null ? void 0 : r.id;
      const o = e.areaList.filter((a) => a.operateType !== "del");
      t.push(...o);
    }), t != null && t.length) {
      const { validResult: e } = (s = P.value) == null ? void 0 : s.tableValidate(t);
      if (!e) return { flag: false };
    }
    return { flag: true };
  }
  async function he() {
    var n, s;
    const { flag: t } = K();
    if (t) try {
      z.value = true;
      const e = C(p.value);
      console.log(e);
      const o = [], r = [], a = [], i = [], x = [];
      for (let b = 0; b < e.length; b++) {
        const l = e[b];
        console.log(h.projectInfo), l.projectId = (n = h.projectInfo) == null ? void 0 : n.id;
        const d = [];
        l.lumpSumSystemType = y.value;
        for (let c = 0; c < l.areaList.length; c++) {
          const D = l.areaList[c];
          D.projectId = (s = h.projectInfo) == null ? void 0 : s.id, D.monomerId = l == null ? void 0 : l.id, D.operateType === "add" ? d.push(D) : D.operateType === "del" ? a.push(D) : Q(l) && x.push(D);
        }
        l.operateType === "add" || d != null && d.length ? o.push(l) : l.operateType === "del" ? r.push(l) : Q(l) && i.push(l);
      }
      await Oe({ saveVO: o, updateAreaVO: x, deleteAreaVO: a, deleteMonomerVO: r, updateMonomerVO: i }), Y(), q("success"), U.remove(`PROJECT_PLAN_${h.projectInfo.id}_DRAFT`), ve({ title: "保存成功", type: "success", duration: 2 * 1e3 });
    } catch (e) {
      console.log("保存失败", e);
    } finally {
      z.value = false;
    }
  }
  function Q(t) {
    const n = t.sourceRow, s = t.sourcePlanRow;
    return t.id !== n.id || t.remark !== n.remark || t.mete !== n.mete || t.type !== n.type || t.itemizedType !== n.itemizedType || t.startDate !== s.startDate || t.endDate !== s.endDate || t.deepenStartDate !== s.deepenStartDate || t.deepenEndDate !== s.deepenEndDate || t.purchaseStartDate !== s.purchaseStartDate || t.purchaseEndDate !== s.purchaseEndDate || t.installStartDate !== s.installStartDate || t.installEndDate !== s.installEndDate || t.processStartDate !== s.processStartDate || t.processEndDate !== s.processEndDate || t.shippingStartDate !== s.shippingStartDate || t.shippingEndDate !== s.shippingEndDate;
  }
  function ge() {
    const t = C(p.value), n = [], s = {}, e = {};
    t.forEach((r) => {
      if (r.operateType === "add") n.push(r);
      else {
        if (r.operateType) {
          const a = C(r);
          delete a.areaList, e[`m_${r.id}`] = a;
        }
        r.areaList.forEach((a) => {
          a.operateType === "add" ? (s[r.id] || (s[r.id] = []), s[r.id].push(a)) : a.operateType && (e[`a_${a.id}`] = a);
        });
      }
    });
    const o = { addMonomerList: n, addAreaObj: s, modifyObj: e, lumpSumSystemType: y.value };
    try {
      U.set(`PROJECT_PLAN_${h.projectInfo.id}_DRAFT`, { ...o }, 6048e5), Ne.success("已存为草稿");
    } catch (r) {
      console.log("缓存错误信息", r), console.log("缓存", o);
    }
  }
  return (t, n) => {
    const s = xe, e = H("common-select"), o = je, r = Le, a = H("common-button"), i = Ie, x = Re, b = H("common-drawer"), l = ye("permission");
    return g(), _(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": u(Y), modelValue: u(A), "onUpdate:modelValue": n[3] || (n[3] = (d) => _e(A) ? A.value = d : null), title: "项目计划创建", "custom-class": "project-plan-container-drawer", "wrapper-closable": false, size: "100%" }, { titleAfter: m(() => {
      var d;
      return [v(s, { size: "medium", effect: "plain", style: { "margin-right": "20px" } }, { default: m(() => {
        var c, D, j, X;
        return [(c = f.projectInfo) != null && c.projectAttribute ? (g(), ee(te, { key: 0 }, [N("span", Ue, L(u(ae).VL[(D = f.projectInfo) == null ? void 0 : D.projectAttribute] || "-"), 1), n[4] || (n[4] = N("span", { style: { margin: "0 10px" } }, " | ", -1))], 64)) : I("", true), (j = f.projectInfo) != null && j.businessType ? (g(), ee(te, { key: 1 }, [N("span", qe, L(u(Pe).VL[(X = f.projectInfo) == null ? void 0 : X.businessType] || "-"), 1), n[5] || (n[5] = N("span", { style: { margin: "0 10px" } }, " | ", -1))], 64)) : I("", true), N("span", null, L(f.projectInfo.serialNumber + "-" + f.projectInfo.shortName), 1), n[6] || (n[6] = N("span", { style: { margin: "0 10px" } }, " | ", -1)), N("span", null, "开工日期：" + L(u(se)(f.projectInfo.startDate, "{y}/{m}/{d}") || "-") + " ~ 完工日期：" + L(u(se)(f.projectInfo.endDate, "{y}/{m}/{d}") || "-"), 1), N("span", Ye, "工期：" + L(u(ze)(f.projectInfo.startDate, f.projectInfo.endDate)) + "天", 1)];
      }), _: 1, __: [6] }), ((d = f.projectInfo) == null ? void 0 : d.projectAttribute) === u(ae).LUMP_SUM_SYSTEM.V ? (g(), _(r, { key: 0 }, { default: m(() => [v(o, { label: "内包制项目管理选项", class: "form-label-require", style: { "margin-bottom": "0" } }, { default: m(() => [v(e, { modelValue: y.value, "onUpdate:modelValue": n[0] || (n[0] = (c) => y.value = c), options: u(V).ENUM, type: "enum", disabled: !B.value, unshowOptions: [u(V).OTHER.K], class: "filter-item", clearable: "", style: { width: "300px" }, placeholder: "请选择管理选项", onChange: ie }, null, 8, ["modelValue", "options", "disabled", "unshowOptions"])]), _: 1 })]), _: 1 })) : I("", true)];
    }), titleRight: m(() => {
      var d, c;
      return [S.value === 2 ? (g(), _(a, { key: 0, size: "mini", type: "warning", style: { float: "right" }, onClick: n[1] || (n[1] = M((D) => S.value--, ["stop"])) }, { default: m(() => n[7] || (n[7] = [O(" 上一步 ")])), _: 1, __: [7] })) : I("", true), S.value === 1 ? (g(), _(a, { key: 1, type: "primary", size: "mini", style: { float: "right" }, disabled: $.value, onClick: M(me, ["stop"]) }, { default: m(() => n[8] || (n[8] = [O(" 下一步 ")])), _: 1, __: [8] }, 8, ["disabled"])) : I("", true), v(a, { size: "mini", type: "warning", disabled: !((d = p.value) != null && d.length), onClick: M(ge, ["stop"]) }, { default: m(() => n[9] || (n[9] = [O(" 存为草稿 ")])), _: 1, __: [9] }, 8, ["disabled"]), S.value === 2 ? (g(), _(a, { key: 2, loading: z.value, size: "mini", type: "success", disabled: !((c = p.value) != null && c.length), onClick: M(he, ["stop"]) }, { default: m(() => n[10] || (n[10] = [O(" 保存 ")])), _: 1, __: [10] }, 8, ["loading", "disabled"])) : I("", true)];
    }), content: m(() => [v(x, { class: "project-plan-steps", active: S.value, simple: "", style: { "margin-bottom": "8px", width: "900px" } }, { default: m(() => [v(i, { title: "创建单体区域计划" }), v(i, { title: "创建部门计划" })]), _: 1 }, 8, ["active"]), Te((g(), _(a, { type: "primary", icon: "el-icon-plus", style: { "margin-bottom": "10px" }, onClick: M(le, ["stop"]) }, { default: m(() => n[11] || (n[11] = [O(" 创建单体 ")])), _: 1, __: [11] })), [[l, u(Be).add], [be, S.value === 1]]), S.value === 1 ? (g(), _(u($e), { key: 0, ref_key: "tableRef", ref: P, monomerList: p.value, maxHeight: u(G) - 43, onToEditMonomer: oe, onAreaRowWatch: J, onDelRow: ue, onVirtualDelRow: De, onUndelete: fe }, null, 8, ["monomerList", "maxHeight"])) : (g(), _(He, { key: 1, ref_key: "tableRef", ref: P, monomerList: p.value, maxHeight: u(G) }, null, 8, ["monomerList", "maxHeight"])), v(u(Fe), { visible: k.value, "onUpdate:visible": n[2] || (n[2] = (d) => k.value = d), info: R.value, onAdd: ce, onEdit: de }, null, 8, ["visible", "info"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, et = Ce(Ge, [["__scopeId", "data-v-c9dfef36"]]);
export {
  et as default
};
