import { ref as f } from "vue";
import { reactive as W } from "vue";
import { computed as b } from "vue";
import { provide as re } from "vue";
import { watch as L } from "vue";
import { nextTick as M } from "vue";
import { resolveDirective as ce } from "vue";
import { withDirectives as fe } from "vue";
import { unref as h } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as x } from "vue";
import { withCtx as A } from "vue";
import { createElementVNode as y } from "vue";
import { ElRadioGroup as de } from "element-plus";
import { Fragment as me } from "vue";
import { renderList as pe } from "vue";
import { createTextVNode as ve } from "vue";
import { toDisplayString as z } from "vue";
import { createBlock as be } from "vue";
import { resolveDynamicComponent as he } from "vue";
import { normalizeStyle as _e } from "vue";
import { ElMessage as $ } from "element-plus";
import { ElRadioButton as Le } from "element-plus";
import { ElForm as Me } from "element-plus";
import { _ as ge, am as v, i as g, bs as k, tB as Ce, yj as q, yk as Ee, yl as xe, o as Ae, b as D } from "../../../../../shared/runtime.js";
import Re from "../../../material-inbound/raw-material/application/components/common-wrapper.vue.js";
import Te from "./module/struc-manuf-table.vue.js";
import Ue from "./module/encl-manuf-table.vue.js";
import "../../../material-inbound/raw-material/application/components/common-header.vue.js";
import "../../../material-inbound/raw-material/application/components/common-footer.vue.js";
import "../../../material-inbound/raw-material/application/components/confirm-dialog.vue.js";
import "../../../../../modules/index-e817c507.js";
import "../../../material-inbound/raw-material/components/project-set-columns.vue.js";
import "../../../material-inbound/raw-material/components/warehouse-set-columns.vue.js";
const Be = { class: "manuf-inbound-application-container" }, Ne = { class: "filter-container" }, Se = { class: "filter-left-box" }, we = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(G, { emit: J }) {
  const Q = J, d = G, X = v.STRUC_MANUFACTURED.V | v.ENCL_MANUFACTURED.V, m = { strucManufList: { K: "strucManufList", L: v.STRUC_MANUFACTURED.L, V: v.STRUC_MANUFACTURED.V, TABLE: Te }, enclManufList: { K: "enclManufList", L: v.ENCL_MANUFACTURED.L, V: v.ENCL_MANUFACTURED.V, TABLE: Ue } }, Y = { purchaseId: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], strucManufList: [], enclManufList: [] }, R = f(), Z = f(), O = f(), T = f(), U = f(false), B = f({}), n = f(), H = f([]), u = f(false), c = W({ strucManufList: null, enclManufList: null }), N = b(() => false);
  function K(e) {
    var t, s;
    return ((s = (t = a[e]) == null ? void 0 : t.filter((o) => {
      var i, l;
      return (l = (i = a.selectObj) == null ? void 0 : i[o.mergeId]) == null ? void 0 : l.isSelected;
    })) == null ? void 0 : s.length) || 0;
  }
  const C = b(() => {
    const e = [];
    return g(a.strucManufList) && a.strucManufList.forEach((t) => {
      var s, o;
      (u.value || (o = (s = a.selectObj) == null ? void 0 : s[t.mergeId]) != null && o.isSelected) && e.push(t);
    }), g(a.enclManufList) && a.enclManufList.forEach((t) => {
      var s, o;
      (u.value || (o = (s = a.selectObj) == null ? void 0 : s[t.mergeId]) != null && o.isSelected) && e.push(t);
    }), e;
  }), ee = b(() => {
    let e = 0;
    return !u.value && N.value && C.value.forEach((t) => {
      g(t.amount) && (e += +t.amount);
    }), k(e, 2);
  }), S = b(() => {
    let e = 0;
    return C.value.forEach((t) => {
      g(t.mete) && (e += +t.mete);
    }), k(e, 2);
  });
  re("matSpecRef", Z);
  const w = (e) => {
    const t = { strucManufList: null, enclManufList: null }, s = ["strucManufList", "enclManufList"];
    let o = false;
    s.forEach((i) => {
      if (g(e[i])) {
        if (!o) {
          o = true;
          const l = L(U, (p) => {
            p && M(() => {
              n.value = i, l();
            });
          }, { immediate: true });
        }
        e[i] = e[i].map((l) => W(l)), t[i] = L(c, (l) => {
          l[i] && (e[i].forEach((p) => {
            var _, r;
            l[i].rowWatch(p), !u.value && ((r = (_ = e.selectObj) == null ? void 0 : _[p.mergeId]) != null && r.isSelected) && l[i].toggleRowSelection(p, true);
          }), M(() => {
            t[i]();
          }));
        }, { immediate: true, deep: true });
      }
    }), te();
  }, { cu: j, form: a, FORM: P } = Ce({ title: "制成品入库", formStore: !d.edit, formStoreKey: "WMS_INBOUND_APPLICATION_MANUF", permission: q, defaultForm: Y, useDraftCallback: w, clearDraftCallback: E, api: d.edit ? Ee : xe }, O, d.detail);
  let V = {};
  d.edit ? V = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : V = { mainBox: ".manuf-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: te, maxHeight: ae, maxHeightStyle: se } = Ae(V), ie = b(() => n.value ? m[n.value].TABLE : m.strucManufList.TABLE);
  L(n, (e) => {
    H.value = a[e], e && M(() => {
      c[e] || (c[e] = R.value);
    });
  }, { immediate: true }), L(H, (e) => {
    a[n.value] = e;
  }), L(() => S.value, (e) => {
    j.props.totalWeight = e;
  }), E();
  const le = b(() => !d.edit);
  P.HOOK.beforeToEdit = async (e, t) => {
    var s;
    d.edit && (t.purchaseId = (s = t.purchaseOrder) == null ? void 0 : s.id, t.logistics || (t.logistics = {}), w(t));
  }, P.HOOK.afterSubmit = () => {
    d.edit && Q("success"), E();
  };
  function ne() {
    if (u.value && D(a.strucManufList) && D(a.enclManufList)) return $.warning("请填写数据"), false;
    if (!u.value && D(C.value)) return $.warning("请选择数据"), false;
    const e = ue();
    return e && (a.list = C.value), e;
  }
  function ue() {
    return Object.keys(c).every((e) => c[e] ? c[e].validate() : true);
  }
  async function oe(e) {
    var t;
    if (E(), T.value = e, j.props.order = e, le.value && (a.strucManufList = [], a.enclManufList = [], a.originStructureList = [], a.originEnclosureList = []), u.value = false, e) {
      if (Object.keys(m).forEach((s) => {
        m[s].V & e.basicClass && (n.value || (n.value = m[s].K), B.value[s] = false), (u.value || !(m[s].V & e.basicClass)) && (a[s] = []);
      }), M(() => {
        c[n.value] = R.value;
      }), (t = e == null ? void 0 : e.details) != null && t.length) {
        a.list = e.details, a.strucManufList = [], a.enclManufList = [];
        for (const s of a.list) switch (s.basicClass) {
          case v.STRUC_MANUFACTURED.V:
            a.strucManufList.push(s);
            break;
          case v.ENCL_MANUFACTURED.V:
            a.enclManufList.push(s);
            break;
        }
        w(a);
      }
    } else M(() => {
      c.strucManufList = null, c.enclManufList = null;
    });
    U.value = true;
  }
  function E() {
    B.value = { strucManufList: true, enclManufList: true }, n.value = void 0, S.value = 0, U.value = false, u.value = false;
  }
  return (e, t) => {
    var l, p, _;
    const s = Le, o = Me, i = ce("permission");
    return fe((F(), I("div", Be, [x(Re, { basicClass: X, "current-basic-class": (l = m[n.value]) == null ? void 0 : l.V, "total-value": S.value, "total-amount": ee.value, "show-total-amount": !u.value && N.value, "contract-unit": (p = T.value) == null ? void 0 : p.unit, "contract-value": (_ = T.value) == null ? void 0 : _.mete, showContractTotal: !u.value && h(a).purchaseId, validate: ne, edit: d.edit, "is-manuf": "", unit: "kg", "total-name": "总量合计", onPurchaseOrderChange: oe }, { default: A(() => [y("div", Ne, [y("div", Se, [x(h(de), { modelValue: n.value, "onUpdate:modelValue": t[0] || (t[0] = (r) => n.value = r), size: "default", class: "filter-item" }, { default: A(() => [(F(), I(me, null, pe(m, (r) => x(s, { key: r.K, value: r.K, disabled: B.value[r.K] }, { default: A(() => [ve(z(r.L) + z(K(r.K) ? `(${K(r.K)})` : ""), 1)]), _: 2 }, 1032, ["value", "disabled"])), 64))]), _: 1 }, 8, ["modelValue"])]), t[1] || (t[1] = y("div", { class: "filter-right-box" }, null, -1))]), x(o, { ref_key: "formRef", ref: O, model: h(a) }, { default: A(() => [(F(), be(he(ie.value), { ref_key: "manufRef", ref: R, "max-height": h(ae), style: _e(h(se)), "bool-party-a": u.value, fillableAmount: N.value }, null, 8, ["max-height", "style", "bool-party-a", "fillableAmount"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["current-basic-class", "total-value", "total-amount", "show-total-amount", "contract-unit", "contract-value", "showContractTotal", "edit"])])), [[i, h(q)]]);
  };
} }, ze = ge(we, [["__scopeId", "data-v-e6bf7ca9"]]);
export {
  ze as default
};
