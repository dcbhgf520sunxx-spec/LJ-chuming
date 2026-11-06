import { ref as f } from "vue";
import { reactive as W } from "vue";
import { computed as b } from "vue";
import { provide as oe } from "vue";
import { watch as M } from "vue";
import { nextTick as L } from "vue";
import { resolveDirective as ce } from "vue";
import { withDirectives as re } from "vue";
import { unref as _ } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as E } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as F } from "vue";
import { ElRadioGroup as fe } from "element-plus";
import { Fragment as me } from "vue";
import { renderList as de } from "vue";
import { createTextVNode as pe } from "vue";
import { toDisplayString as $ } from "vue";
import { createBlock as ve } from "vue";
import { resolveDynamicComponent as _e } from "vue";
import { normalizeStyle as he } from "vue";
import { ElMessage as k } from "element-plus";
import { ElRadioButton as be } from "element-plus";
import { ElForm as Me } from "element-plus";
import { _ as Le, am as p, i as g, bs as q, tB as ge, yj as G, yk as Ce, yl as Ae, o as Ee, b as O, jZ as xe } from "../../../../shared/runtime.js";
import Te from "../raw-material/application/components/common-wrapper.vue.js";
import Re from "./module/struc-manuf-table.vue.js";
import Ue from "./module/encl-manuf-table.vue.js";
import "../raw-material/application/components/common-header.vue.js";
import "../raw-material/application/components/common-footer.vue.js";
import "../raw-material/application/components/confirm-dialog.vue.js";
import "../../../../modules/index-e817c507.js";
import "../raw-material/components/project-set-columns.vue.js";
import "../raw-material/components/warehouse-set-columns.vue.js";
const Be = { class: "manuf-inbound-application-container" }, Ne = { class: "filter-container" }, ye = { class: "filter-left-box" }, Se = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(Y, { emit: Z }) {
  const J = Z, v = Y, Q = p.STRUC_MANUFACTURED.V | p.ENCL_MANUFACTURED.V, m = { strucManufList: { K: "strucManufList", L: p.STRUC_MANUFACTURED.L, V: p.STRUC_MANUFACTURED.V, TABLE: Re }, enclManufList: { K: "enclManufList", L: p.ENCL_MANUFACTURED.L, V: p.ENCL_MANUFACTURED.V, TABLE: Ue } }, X = { purchaseId: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], strucManufList: [], enclManufList: [] }, T = f(), I = f(), D = f(), R = f(), U = f(false), B = f({}), n = f(), H = f([]), u = f(false), r = W({ strucManufList: null, enclManufList: null }), N = b(() => false);
  function K(e) {
    var t, a;
    return ((a = (t = s[e]) == null ? void 0 : t.filter((o) => {
      var l, i;
      return (i = (l = s.selectObj) == null ? void 0 : l[o.mergeId]) == null ? void 0 : i.isSelected;
    })) == null ? void 0 : a.length) || 0;
  }
  const C = b(() => {
    const e = [];
    return g(s.strucManufList) && s.strucManufList.forEach((t) => {
      var a, o;
      (u.value || (o = (a = s.selectObj) == null ? void 0 : a[t.mergeId]) != null && o.isSelected) && e.push(t);
    }), g(s.enclManufList) && s.enclManufList.forEach((t) => {
      var a, o;
      (u.value || (o = (a = s.selectObj) == null ? void 0 : a[t.mergeId]) != null && o.isSelected) && e.push(t);
    }), e;
  }), ee = b(() => {
    let e = 0;
    return !u.value && N.value && C.value.forEach((t) => {
      g(t.amount) && (e += +t.amount);
    }), q(e, 2);
  }), y = b(() => {
    let e = 0;
    return C.value.forEach((t) => {
      g(t.mete) && (e += +t.mete);
    }), q(e, 2);
  });
  oe("matSpecRef", I);
  const S = (e) => {
    const t = { strucManufList: null, enclManufList: null }, a = ["strucManufList", "enclManufList"];
    let o = false;
    a.forEach((l) => {
      if (g(e[l])) {
        if (!o) {
          o = true;
          const i = M(U, (d) => {
            d && L(() => {
              n.value = l, i();
            });
          }, { immediate: true });
        }
        e[l] = e[l].map((i) => W(i)), t[l] = M(r, (i) => {
          i[l] && (e[l].forEach((d) => {
            var h, c;
            i[l].rowWatch(d), !u.value && ((c = (h = e.selectObj) == null ? void 0 : h[d.mergeId]) != null && c.isSelected) && i[l].toggleRowSelection(d, true);
          }), L(() => {
            t[l]();
          }));
        }, { immediate: true, deep: true });
      }
    }), te();
  }, { cu: j, form: s, FORM: P } = ge({ title: "制成品入库", formStore: !v.edit, formStoreKey: "WMS_INBOUND_APPLICATION_MANUF", permission: G, defaultForm: X, useDraftCallback: S, clearDraftCallback: A, api: v.edit ? Ce : Ae }, D, v.detail);
  let V = {};
  v.edit ? V = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : V = { mainBox: ".manuf-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: te, maxHeight: ae, maxHeightStyle: se } = Ee(V), le = b(() => n.value ? m[n.value].TABLE : m.strucManufList.TABLE);
  M(n, (e) => {
    H.value = s[e], e && L(() => {
      r[e] || (r[e] = T.value);
    });
  }, { immediate: true }), M(H, (e) => {
    s[n.value] = e;
  }), M(() => y.value, (e) => {
    j.props.totalWeight = e;
  }), A(), P.HOOK.beforeToEdit = async (e, t) => {
    var a;
    v.edit && (t.purchaseId = (a = t.purchaseOrder) == null ? void 0 : a.id, t.logistics || (t.logistics = {}), S(t));
  }, P.HOOK.afterSubmit = () => {
    v.edit && J("success"), A();
  };
  function ie() {
    if (u.value && O(s.strucManufList) && O(s.enclManufList)) return k.warning("请填写数据"), false;
    if (!u.value && O(C.value)) return k.warning("请选择数据"), false;
    const e = ne();
    return e && (s.list = C.value), e;
  }
  function ne() {
    return Object.keys(r).every((e) => r[e] ? r[e].validate() : true);
  }
  async function ue(e) {
    var t;
    if (A(), R.value = e, j.props.order = e, u.value = (e == null ? void 0 : e.supplyType) === xe.PARTY_A.V, e) {
      if (Object.keys(m).forEach((a) => {
        m[a].V & e.basicClass && (n.value || (n.value = m[a].K), B.value[a] = false), (u.value || !(m[a].V & e.basicClass)) && (s[a] = []);
      }), L(() => {
        r[n.value] = T.value;
      }), (t = e == null ? void 0 : e.details) != null && t.length) {
        s.list = e.details, s.strucManufList = [], s.enclManufList = [];
        for (const a of s.list) switch (a.basicClass) {
          case p.STRUC_MANUFACTURED.V:
            s.strucManufList.push(a);
            break;
          case p.ENCL_MANUFACTURED.V:
            s.enclManufList.push(a);
            break;
        }
        S(s);
      }
    } else L(() => {
      r.strucManufList = null, r.enclManufList = null;
    });
    U.value = true;
  }
  function A() {
    B.value = { strucManufList: true, enclManufList: true }, n.value = void 0, y.value = 0, U.value = false, u.value = false;
  }
  return (e, t) => {
    var i, d, h;
    const a = be, o = Me, l = ce("permission");
    return re((w(), z("div", Be, [E(Te, { basicClass: Q, "current-basic-class": (i = m[n.value]) == null ? void 0 : i.V, "total-value": y.value, "total-amount": ee.value, "show-total-amount": !u.value && N.value, "contract-unit": (d = R.value) == null ? void 0 : d.unit, "contract-value": (h = R.value) == null ? void 0 : h.mete, showContractTotal: !u.value && _(s).purchaseId, validate: ie, edit: v.edit, "is-manuf": "", unit: "kg", "total-name": "总量合计", onPurchaseOrderChange: ue }, { default: x(() => [F("div", Ne, [F("div", ye, [E(_(fe), { modelValue: n.value, "onUpdate:modelValue": t[0] || (t[0] = (c) => n.value = c), size: "default", class: "filter-item" }, { default: x(() => [(w(), z(me, null, de(m, (c) => E(a, { key: c.K, value: c.K, disabled: B.value[c.K] }, { default: x(() => [pe($(c.L) + $(K(c.K) ? `(${K(c.K)})` : ""), 1)]), _: 2 }, 1032, ["value", "disabled"])), 64))]), _: 1 }, 8, ["modelValue"])]), t[1] || (t[1] = F("div", { class: "filter-right-box" }, null, -1))]), E(o, { ref_key: "formRef", ref: D, model: _(s) }, { default: x(() => [(w(), ve(_e(le.value), { ref_key: "manufRef", ref: T, "max-height": _(ae), style: he(_(se)), "bool-party-a": u.value, fillableAmount: N.value }, null, 8, ["max-height", "style", "bool-party-a", "fillableAmount"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["current-basic-class", "total-value", "total-amount", "show-total-amount", "contract-unit", "contract-value", "showContractTotal", "edit"])])), [[l, _(G)]]);
  };
} }, $e = Le(Se, [["__scopeId", "data-v-58e903e7"]]);
export {
  $e as default
};
