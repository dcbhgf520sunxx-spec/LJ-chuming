import { useStore as Oe } from "vuex";
import { ref as h } from "vue";
import { reactive as ue } from "vue";
import { computed as E } from "vue";
import { provide as He } from "vue";
import { watch as C } from "vue";
import { nextTick as W } from "vue";
import { resolveComponent as re } from "vue";
import { resolveDirective as Ne } from "vue";
import { withDirectives as Me } from "vue";
import { unref as _ } from "vue";
import { openBlock as B } from "vue";
import { createElementBlock as ce } from "vue";
import { createVNode as V } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as F } from "vue";
import { ElRadioGroup as De } from "element-plus";
import { Fragment as je } from "vue";
import { renderList as Ie } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as de } from "vue";
import { createBlock as K } from "vue";
import { createCommentVNode as G } from "vue";
import { resolveDynamicComponent as Fe } from "vue";
import { normalizeStyle as Ke } from "vue";
import { ElMessage as P } from "element-plus";
import { ElRadioButton as Ue } from "element-plus";
import { ElTooltip as qe } from "element-plus";
import { ElForm as Ye } from "element-plus";
import { _ as $e, jY as ze, am as Q, sQ as ke, gS as Ge, i as d, b as v, bs as U, D as X, tB as Qe, yy as me, yk as Xe, yl as Ze, o as fe, bR as Je, wB as he, iX as pe, cV as et, jN as tt, cQ as at, aI as ge, jZ as lt } from "../../../../../../shared/runtime.js";
import it from "../components/common-wrapper.vue.js";
import st from "./module/steel-plate-table.vue.js";
import nt from "./module/section-steel-table.vue.js";
import ot from "./module/steel-coil-table.vue.js";
import "../components/common-header.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/index-e817c507.js";
import "../../components/project-set-columns.vue.js";
import "../../components/warehouse-set-columns.vue.js";
import "../../../../../../modules/use-over-receive-ba08adae.js";
import "../components/inbound-quantity-column.vue.js";
const ut = { class: "steel-inbound-application-container" }, rt = { class: "filter-container" }, ct = { class: "filter-left-box" }, dt = { class: "filter-right-box" }, mt = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(ve, { emit: be }) {
  const Z = Oe(), _e = be, { inboundFillWayCfg: J } = ze(), T = ve, L = { steelPlateList: { K: "steelPlateList", L: "钢板", V: Q.STEEL_PLATE.V, TABLE: st }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: Q.SECTION_STEEL.V, TABLE: nt }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: Q.STEEL_COIL.V, TABLE: ot } }, Le = { purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], steelPlateList: [], sectionSteelList: [], steelCoilList: [] }, A = h(), p = h(), ee = h(), te = h(), m = h(), q = h(false), R = h({}), N = h(false), r = h(), O = h([]), o = h(false), H = h(false), b = ue({ steelPlateList: null, sectionSteelList: null, steelCoilList: null }), { baseUnit: ae } = ke(), M = E(() => J.value ? !!(J.value.amountFillWay === Ge.APPLICATION.V && H.value) : false), Y = E(() => !!(r.value && m.value));
  function le(e) {
    var t, i, s;
    return o.value || H ? ((t = l[e]) == null ? void 0 : t.length) || 0 : ((s = (i = l[e]) == null ? void 0 : i.filter((u) => {
      var n;
      return (n = l.selectObj[u.mergeId]) == null ? void 0 : n.isSelected;
    })) == null ? void 0 : s.length) || 0;
  }
  const D = E(() => {
    const e = [];
    return d(l.steelPlateList) && l.steelPlateList.forEach((t) => {
      var i, s;
      (o.value || !o.value && v((i = m.value) == null ? void 0 : i.details) || (s = l.selectObj[t.mergeId]) != null && s.isSelected) && e.push(t);
    }), d(l.sectionSteelList) && l.sectionSteelList.forEach((t) => {
      var i, s;
      (o.value || !o.value && v((i = m.value) == null ? void 0 : i.details) || (s = l.selectObj[t.mergeId]) != null && s.isSelected) && e.push(t);
    }), d(l.steelCoilList) && l.steelCoilList.forEach((t) => {
      var i, s;
      if (o.value || !o.value && v((i = m.value) == null ? void 0 : i.details) || (s = l.selectObj[t.mergeId]) != null && s.isSelected) {
        const u = { ...t };
        u.quantity = u.length, e.push(u);
      }
    }), e;
  }), ye = E(() => {
    let e = 0;
    return !o.value && M.value && D.value.forEach((t) => {
      d(t.amount) && (e += +t.amount);
    }), U(e, X.YUAN);
  }), ie = E(() => {
    let e = 0;
    return D.value.forEach((t) => {
      d(t.weighingTotalWeight) && (e += +t.weighingTotalWeight);
    }), U(e, 2);
  });
  He("matSpecRef", p);
  const $ = (e) => {
    const t = { steelPlateList: null, sectionSteelList: null, steelCoilList: null }, i = { steelPlateList: null, sectionSteelList: null, steelCoilList: null }, s = ["steelPlateList", "sectionSteelList", "steelCoilList"];
    let u = false;
    s.forEach((n) => {
      if (d(e[n])) {
        if (!u) {
          u = true;
          const a = C(q, (g) => {
            g && W(() => {
              r.value = n, a();
            });
          }, { immediate: true });
        }
        e[n] = e[n].map((a) => ue(a)), t[n] = C(b, (a) => {
          a[n] && (e[n].forEach((g) => {
            var S, w;
            a[n].rowWatch(g), !o.value && !H.value && ((w = (S = e.selectObj) == null ? void 0 : S[g.mergeId]) != null && w.isSelected) && a[n].toggleRowSelection(g, true);
          }), i[n] = C(p, () => {
            p.value && (p.value.initSelected(e[n].map((g) => ({ sn: g.sn, classifyId: g.classifyId }))), W(() => {
              i[n]();
            }));
          }, { immediate: true }), W(() => {
            t[n]();
          }));
        }, { immediate: true, deep: true });
      }
    }), Se();
  }, j = h(!T.edit), { cu: f, form: l, FORM: se } = Qe({ title: "钢材入库", formStore: !T.edit, formStoreKey: "WMS_INBOUND_APPLICATION_STEEL", permission: me, defaultForm: Le, clearDraftCallback: I, api: T.edit ? Xe : Ze }, ee, T.detail), { maxHeight: Te } = fe({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => te.value.loaded);
  let z = {};
  T.edit ? z = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : z = { mainBox: ".steel-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: Se, maxHeight: we, maxHeightStyle: Ee } = fe(z), Ce = E(() => r.value ? L[r.value].TABLE : L.steelPlateList.TABLE), We = E(() => {
    const e = m.value && m.value.weightMeasurementMode === Je.OVERWEIGHT.V, t = !R.value.steelPlateList || !R.value.sectionSteelList;
    return e && t;
  }), ne = E(() => {
    var e;
    return (e = l.list) == null ? void 0 : e.filter((t) => {
      var i, s;
      return (s = (i = f == null ? void 0 : f.submitResult) == null ? void 0 : i.data) == null ? void 0 : s.includes(t.classifyId);
    });
  });
  C(r, (e) => {
    e ? (O.value = l[e], W(() => {
      var t;
      b[e] || (b[e] = A.value), (t = A.value) == null || t.setSelect();
    })) : O.value = [];
  }, { immediate: true, deep: true }), C(O, (e) => {
    r.value && (l[r.value] = e);
  }), C(() => ie.value, (e) => {
    f.props.totalWeight = e;
  }), I(), se.HOOK.beforeToEdit = async (e, t) => {
    var i;
    T.edit && (t.purchaseId = (i = t.purchaseOrder) == null ? void 0 : i.id, t.logistics || (t.logistics = {}), await he(t), $(t));
  }, se.HOOK.afterSubmit = () => {
    T.edit && _e("success"), I();
  };
  function xe() {
    var e, t;
    if (d(ne.value) && d((e = f == null ? void 0 : f.submitResult) == null ? void 0 : e.data)) {
      P.error("请删除全部标红数据");
      return;
    }
    N.value = true, ((t = f == null ? void 0 : f.submitResult) == null ? void 0 : t.code) === 40206 && p.value && (Z.dispatch("config/fetchMatClsTree"), f.submitResult.code = null, Z.state.config.classifySpec = { specKV: [] });
  }
  function Pe() {
    var t;
    if ((o.value || !o.value && v((t = m.value) == null ? void 0 : t.details)) && v(l.steelPlateList) && v(l.sectionSteelList) && v(l.steelCoilList)) return P.warning("请填写数据"), false;
    if (!o.value && d(m.value.details) && v(D.value)) return P.warning("请选择数据"), false;
    const e = Be();
    if (e) {
      const i = [];
      if (D.value.forEach((s) => {
        var u;
        if ((u = s.applyPurchase) != null && u.length) {
          let n = s.weighingTotalWeight;
          s.applyPurchase.forEach((a, g) => {
            var S, w;
            if (a.quantity) {
              let y = 0;
              g !== s.applyPurchase.length - 1 && n !== 0 ? (y = U(a.theoryTotalWeight / s.theoryTotalWeight * s.weighingTotalWeight, ae.value[s.basicClass].weight.precision, { toNum: true }), n -= y) : y += n, i.push({ ...s, ...a, quantity: a.quantity, projectId: (S = a.project) == null ? void 0 : S.id, uid: ge(), mete: y, weight: y, amount: s.unitPrice ? pe(y * s.unitPrice, X.YUAN) : void 0, applyPurchaseId: a.applyPurchaseId, purchaseDetailId: a.purchaseDetailId, purchaseProjectDisabled: a.applyPurchaseId ? !((w = a.project) != null && w.id) : false });
            }
          });
        } else i.push({ ...s, uid: ge(), mete: s.weighingTotalWeight, weight: s.weighingTotalWeight });
      }), l.list = i, d(ne.value)) return P.error("请先删除标红数据并重新添加"), false;
    }
    return e;
  }
  function Be() {
    return Object.keys(b).every((e) => b[e] ? b[e].validate() : true);
  }
  function Ve(e) {
    return A.value.rowInit(e);
  }
  function Ae() {
    if (!l.loadingWeight) {
      P.warning("请先输入过磅重量");
      return;
    }
    let e = [], t = [], i = 0;
    if (d(l.steelPlateList) && (e = l.steelPlateList.filter((a) => (i += a.theoryTotalWeight ? a.theoryTotalWeight : 0, a.theoryTotalWeight))), d(l.sectionSteelList) && (t = l.sectionSteelList.filter((a) => (i += a.theoryTotalWeight ? a.theoryTotalWeight : 0, a.theoryTotalWeight))), v(e) && v(t)) {
      P.warning("您未填写完整钢板或型材的信息, 或它们的理论重量过小");
      return;
    }
    let s = 0;
    d(l.steelCoilList) && l.steelCoilList.forEach((a) => {
      s += a.weighingTotalWeight ? a.weighingTotalWeight : 0;
    });
    let u = l.loadingWeight - s - i;
    const n = (a) => {
      a.weighingTotalWeight = u ? U(a.theoryTotalWeight / i * u + a.theoryTotalWeight, ae.value[a.basicClass].weight.precision, { toNum: true }) : a.theoryTotalWeight, u -= a.weighingTotalWeight - a.theoryTotalWeight, i -= a.theoryTotalWeight;
    };
    e.forEach((a) => n(a)), t.forEach((a) => n(a)), P.warning("已自动分配车次/船次过磅重量");
  }
  async function Re(e) {
    var t;
    I(), m.value = e, f.props.order = e, o.value = (e == null ? void 0 : e.supplyType) === lt.PARTY_A.V, H.value = v(e == null ? void 0 : e.details), j.value && (l.list = []), Object.keys(L).forEach((i) => {
      if (j.value && (l[i] = []), L[i].V & (e == null ? void 0 : e.basicClass) ? (r.value || (r.value = L[i].K), R.value[i] = false) : l[i] = [], j.value) {
        const s = C(p, () => {
          p.value && (p.value.clearByBasicClass(L[i].V), W(() => {
            s();
          }));
        }, { immediate: true });
      }
    }), e ? (W(() => {
      b[r.value] = A.value, o.value && j.value && $(l);
    }), !o.value && ((t = e == null ? void 0 : e.details) != null && t.length) && (l.list = e.details || [], await he(l), $(l))) : W(() => {
      b.steelPlateList = null, b.sectionSteelList = null, b.steelCoilList = null;
    }), q.value = true;
  }
  function I() {
    R.value = { steelPlateList: true, sectionSteelList: true, steelCoilList: true }, r.value = void 0, q.value = false, o.value = false, l.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }
  return f.props.import = (e) => {
    var n;
    const t = r.value, i = l[t].length;
    l[t].push.apply(l[t], e);
    const s = l[t].length;
    for (let a = i; a < s; a++) M.value || (l[t][a].amount = void 0, l[t][a].unitPrice = void 0), d((n = l[t][a]) == null ? void 0 : n.amount) && (l[t][a].amount = pe(l[t][a].amount, X.YUAN)), b[t].rowWatch(l[t][a]);
    const u = C(p, () => {
      p.value && (p.value.initSelected(e.map((a) => ({ sn: a.sn, classifyId: a.classifyId }))), W(() => {
        u();
      }));
    }, { immediate: true });
  }, (e, t) => {
    var S, w, y, oe;
    const i = Ue, s = re("common-button"), u = qe, n = Ye, a = re("common-drawer"), g = Ne("permission");
    return Me((B(), ce("div", ut, [V(it, { "basic-class": _(et), "contract-unit": (S = m.value) == null ? void 0 : S.meteUnit, "contract-value": (w = m.value) == null ? void 0 : w.mete, "current-basic-class": (y = L[r.value]) == null ? void 0 : y.V, edit: T.edit, "inbound-unit": _(tt).weight.unit, "inbound-value": (oe = m.value) == null ? void 0 : oe.inboundTotalMete, "show-total-amount": !o.value && M.value, showContractTotal: !o.value && !!_(l).purchaseId, showInboundTotal: !o.value && !!_(l).purchaseId, "total-amount": ye.value, "total-name": o.value ? "总量合计" : "本次实收", "total-value": ie.value, validate: Pe, unit: "kg", onPurchaseOrderChange: Re }, { default: x(() => [F("div", rt, [F("div", ct, [V(_(De), { modelValue: r.value, "onUpdate:modelValue": t[0] || (t[0] = (c) => r.value = c), class: "filter-item", size: "default" }, { default: x(() => [(B(), ce(je, null, Ie(L, (c) => V(i, { key: c.K, disabled: R.value[c.K], value: c.K }, { default: x(() => [k(de(c.L) + de(le(c.K) ? `(${le(c.K)})` : ""), 1)]), _: 2 }, 1032, ["disabled", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), F("div", dt, [We.value ? (B(), K(s, { key: 0, disabled: !r.value, class: "filter-item", type: "warning", onClick: Ae }, { default: x(() => t[3] || (t[3] = [k(" 按过磅重量自动分配（钢卷不参与分配) ")])), _: 1, __: [3] }, 8, ["disabled"])) : G("", true), V(u, { disabled: Y.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: x(() => {
      var c;
      return [F("span", null, [o.value || !o.value && _(v)((c = m.value) == null ? void 0 : c.details) ? (B(), K(s, { key: 0, disabled: !Y.value, class: "filter-item", type: "success", onClick: xe }, { default: x(() => t[4] || (t[4] = [k(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])) : G("", true)])];
    }), _: 1 }, 8, ["disabled"])])]), V(n, { ref_key: "formRef", ref: ee, model: _(l) }, { default: x(() => [(B(), K(Fe(Ce.value), { ref_key: "steelRef", ref: A, "bool-party-a": o.value, fillableAmount: M.value, "max-height": _(we), noDetail: H.value, style: Ke(_(Ee)) }, null, 8, ["bool-party-a", "fillableAmount", "max-height", "noDetail", "style"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "contract-unit", "contract-value", "current-basic-class", "edit", "inbound-unit", "inbound-value", "show-total-amount", "showContractTotal", "showInboundTotal", "total-amount", "total-name", "total-value"]), V(a, { ref_key: "drawerRef", ref: te, modelValue: N.value, "onUpdate:modelValue": t[2] || (t[2] = (c) => N.value = c), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: x(() => [Y.value ? (B(), K(at, { key: 0, ref_key: "matSpecRef", ref: p, modelValue: O.value, "onUpdate:modelValue": t[1] || (t[1] = (c) => O.value = c), "basic-class": L[r.value].V, "max-height": _(Te), "row-init-fn": Ve, "table-width": 350, visible: N.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])) : G("", true)]), _: 1 }, 8, ["modelValue"])])), [[g, _(me)]]);
  };
} }, Wt = $e(mt, [["__scopeId", "data-v-a23c5f71"]]);
export {
  Wt as default
};
