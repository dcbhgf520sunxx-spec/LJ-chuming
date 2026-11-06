import { useStore as W } from "vuex";
import { ref as l } from "vue";
import { provide as E } from "vue";
import { watch as B } from "vue";
import { computed as G } from "vue";
import { watchEffect as J } from "vue";
import { nextTick as X } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as Z } from "vue";
import { createElementBlock as ee } from "vue";
import { createVNode as c } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as T } from "vue";
import { createTextVNode as H } from "vue";
import { unref as s } from "vue";
import { ElMessage as v } from "element-plus";
import { ElForm as te } from "element-plus";
import { _ as ae, am as ie, tB as se, wx as M, o as N, wc as k, vv as ne, L as oe, vw as re, vx as le, cQ as ce, wp as ue, b as me, i as x } from "../../../../../../shared/runtime.js";
import { s as fe } from "../../../../../../modules/aux-material-a427f83d.js";
import pe from "../components/common-wrapper.vue.js";
import de from "./module/aux-mat-table.vue.js";
import ve from "../components/inventory-drawer.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/use-approval-cfg-0a67817c.js";
const ye = { class: "aux-mat-requisitions-application-container" }, _e = { class: "filter-container" }, Ie = { class: "filter-right-box" }, be = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false } }, emits: ["success"], setup(C, { emit: U }) {
  const h = W(), O = U, y = C, j = { list: [], originInventoryInfo: {} }, p = l(), u = l(), g = l(), w = l(), _ = l(false), S = l({}), r = l(), d = l(false), I = ie.MATERIAL.V, R = l({});
  E("useInventoryInfo", R), E("matSpecRef", u);
  const { cu: o, form: t, FORM: F } = se({ title: "辅材申购", defaultForm: j, clearDraftCallback: b, api: y.isEdit ? M.edit : M.add }, g, y.detail);
  B(() => y.detail, (a = {}) => {
    t.type = a.type, t.materialType = a.materialType, t.projectId = a.projectId;
  }, { deep: true, immediate: true });
  const { maxHeight: z } = N({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => w.value.loaded), { maxHeight: A } = N({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 10 }), V = G(() => {
    var a;
    return (a = t.list) == null ? void 0 : a.filter((e) => {
      var i, n;
      return (n = (i = o == null ? void 0 : o.submitResult) == null ? void 0 : i.data) == null ? void 0 : n.includes(e.classifyId);
    });
  });
  b(), J(() => {
    var a;
    if ((a = t.list) != null && a.length) {
      const e = {};
      for (let i = 0; i < t.list.length; i++) {
        const n = t.list[i];
        n.requisitionMode === k.USE_INVENTORY.V && (e[n.materialInventoryId] ? e[n.materialInventoryId] += n.quantity : e[n.materialInventoryId] = n.quantity);
      }
      R.value = e;
    }
  }), F.HOOK.afterSubmit = () => {
    O("success"), b();
  };
  function Q(a, e) {
    S.value = a, r.value = e, _.value = true;
  }
  function L(a, e) {
    const i = e.id;
    t.originInventoryInfo || (t.originInventoryInfo = {}), t.originInventoryInfo[i] = { quantity: e.quantity, frozenQuantity: e.frozenQuantity }, t.list[r.value].quantity = a, t.list[r.value].canUseQuantity = e.quantity, t.list[r.value].color = e.color, t.list[r.value].brand = e.brand, t.list[r.value].unitNet = e.unitNet, t.list[r.value].mete = e.quantity * e.unitNet, t.list[r.value].requisitionMode = k.USE_INVENTORY.V, t.list[r.value].materialInventoryId = i;
  }
  function D() {
    return t.type !== ue.PUBLIC.V && me(t.projectId) ? (v.warning("请选择项目"), false) : x(V.value) ? (v.error("请先删除标红数据并重新添加"), false) : p.value ? p.value.validate() : true;
  }
  function K(a) {
    return p.value.rowInit(a);
  }
  function b() {
    u.value && u.value.clear();
  }
  function Y() {
    var a, e;
    if (x(V.value) && x((a = o == null ? void 0 : o.submitResult) == null ? void 0 : a.data)) {
      v.error("请删除全部标红数据");
      return;
    }
    d.value = true, ((e = o.submitResult) == null ? void 0 : e.code) === 40206 && u.value && (h.dispatch("config/fetchMatClsTree"), o.submitResult.code = null, h.state.config.classifySpec = { specKV: [] });
  }
  function $(a) {
    try {
      o.props.import(a);
    } catch (e) {
      v.error({ message: e.message, duration: 5e3 });
    }
  }
  return o.props.import = (a) => {
    t.list.push.apply(t.list, a);
    const e = B(u, () => {
      u.value && (u.value.initSelected(a.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), X(() => {
        e();
      }));
    }, { immediate: true });
  }, (a, e) => {
    const i = q("common-button"), n = te, P = q("common-drawer");
    return Z(), ee("div", ye, [c(pe, { "basic-class": s(I), "show-total": false, validate: D }, { default: f(() => [T("div", _e, [T("div", Ie, [c(i, { class: "filter-item", type: "success", onClick: Y }, { default: f(() => e[3] || (e[3] = [H(" 添加物料")])), _: 1, __: [3] }), c(ne, { template: s(fe), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: $ }, null, 8, ["template"]), c(oe, { fn: s(re), params: { basicClass: s(I), receiptType: s(le).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: f(() => e[4] || (e[4] = [H(" 辅材清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), c(n, { ref_key: "formRef", ref: g, model: s(t) }, { default: f(() => [c(de, { ref_key: "tableRef", ref: p, "max-height": s(A), onSearchInventory: Q }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class"]), c(P, { ref_key: "drawerRef", ref: w, modelValue: d.value, "onUpdate:modelValue": e[1] || (e[1] = (m) => d.value = m), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: f(() => [c(ce, { ref_key: "matSpecRef", ref: u, modelValue: s(t).list, "onUpdate:modelValue": e[0] || (e[0] = (m) => s(t).list = m), "basic-class": s(I), "max-height": s(z), "row-init-fn": K, "table-width": 430, visible: d.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), c(s(ve), { visible: _.value, "onUpdate:visible": e[2] || (e[2] = (m) => _.value = m), params: S.value, onUseInventory: L }, null, 8, ["visible", "params"])]);
  };
} }, qe = ae(be, [["__scopeId", "data-v-10f21147"]]);
export {
  qe as default
};
