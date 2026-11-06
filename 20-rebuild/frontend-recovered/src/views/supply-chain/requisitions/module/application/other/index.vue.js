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
import { unref as n } from "vue";
import { ElMessage as v } from "element-plus";
import { ElForm as te } from "element-plus";
import { _ as ae, am as ie, tB as se, wx as N, o as k, wc as M, vv as ne, L as oe, vw as re, vx as le, cQ as ce, wp as ue, b as me, i as x } from "../../../../../../shared/runtime.js";
import { s as fe } from "../../../../../../modules/other-e93f8d3e.js";
import pe from "../components/common-wrapper.vue.js";
import de from "../auxiliary-material/module/aux-mat-table.vue.js";
import ve from "../components/inventory-drawer.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/use-approval-cfg-0a67817c.js";
const ye = { class: "aux-mat-requisitions-application-container" }, _e = { class: "filter-container" }, Ie = { class: "filter-right-box" }, be = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false } }, emits: ["success"], setup(C, { emit: O }) {
  const h = W(), U = O, y = C, j = { list: [], originInventoryInfo: {} }, p = l(), u = l(), g = l(), w = l(), _ = l(false), S = l({}), r = l(), d = l(false), I = ie.OTHER.V, R = l({});
  E("useInventoryInfo", R), E("matSpecRef", u);
  const { cu: s, form: t, FORM: F } = se({ title: "其它申购", defaultForm: j, clearDraftCallback: b, api: y.isEdit ? N.edit : N.add }, g, y.detail);
  B(() => y.detail, (a = {}) => {
    t.type = a.type, t.materialType = a.materialType, t.projectId = a.projectId;
  }, { deep: true, immediate: true });
  const { maxHeight: z } = k({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => w.value.loaded), { maxHeight: Q } = k({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 10 }), V = G(() => {
    var a;
    return (a = t.list) == null ? void 0 : a.filter((e) => {
      var i, o;
      return (o = (i = s == null ? void 0 : s.submitResult) == null ? void 0 : i.data) == null ? void 0 : o.includes(e.classifyId);
    });
  });
  b(), J(() => {
    var a;
    if ((a = t.list) != null && a.length) {
      const e = {};
      for (let i = 0; i < t.list.length; i++) {
        const o = t.list[i];
        o.requisitionMode === M.USE_INVENTORY.V && (e[o.materialInventoryId] ? e[o.materialInventoryId] += o.quantity : e[o.materialInventoryId] = o.quantity);
      }
      R.value = e;
    }
  }), F.HOOK.afterSubmit = () => {
    U("success"), b();
  };
  function A(a, e) {
    S.value = a, r.value = e, _.value = true;
  }
  function D(a, e) {
    const i = e.id;
    t.originInventoryInfo || (t.originInventoryInfo = {}), t.originInventoryInfo[i] = { quantity: e.quantity, frozenQuantity: e.frozenQuantity }, t.list[r.value].quantity = a, t.list[r.value].canUseQuantity = e.quantity, t.list[r.value].color = e.color, t.list[r.value].brand = e.brand, t.list[r.value].unitNet = e.unitNet, t.list[r.value].mete = e.quantity * e.unitNet, t.list[r.value].requisitionMode = M.USE_INVENTORY.V, t.list[r.value].materialInventoryId = i;
  }
  function K() {
    return t.type !== ue.PUBLIC.V && me(t.projectId) ? (v.warning("请选择项目"), false) : x(V.value) ? (v.error("请先删除标红数据并重新添加"), false) : p.value ? p.value.validate() : true;
  }
  function L(a) {
    return p.value.rowInit(a);
  }
  function b() {
    u.value && u.value.clear();
  }
  function Y() {
    var a, e;
    if (x(V.value) && x((a = s == null ? void 0 : s.submitResult) == null ? void 0 : a.data)) {
      v.error("请删除全部标红数据");
      return;
    }
    d.value = true, ((e = s == null ? void 0 : s.submitResult) == null ? void 0 : e.code) === 40206 && u.value && (h.dispatch("config/fetchMatClsTree"), s.submitResult.code = null, h.state.config.classifySpec = { specKV: [] });
  }
  function $(a) {
    try {
      s.props.import(a);
    } catch (e) {
      v.error({ message: e.message, duration: 5e3 });
    }
  }
  return s.props.import = (a) => {
    t.list.push.apply(t.list, a);
    const e = B(u, () => {
      u.value && (u.value.initSelected(a.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), X(() => {
        e();
      }));
    }, { immediate: true });
  }, (a, e) => {
    const i = q("common-button"), o = te, P = q("common-drawer");
    return Z(), ee("div", ye, [c(pe, { "basic-class": n(I), "show-total": false, validate: K }, { default: f(() => [T("div", _e, [T("div", Ie, [c(i, { class: "filter-item", type: "success", onClick: Y }, { default: f(() => e[3] || (e[3] = [H(" 添加物料 ")])), _: 1, __: [3] }), c(ne, { template: n(fe), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: $ }, null, 8, ["template"]), c(oe, { fn: n(re), params: { basicClass: n(I), receiptType: n(le).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: f(() => e[4] || (e[4] = [H(" 其它清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), c(o, { ref_key: "formRef", ref: g, model: n(t) }, { default: f(() => [c(de, { ref_key: "tableRef", ref: p, "max-height": n(Q), onSearchInventory: A }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class"]), c(P, { ref_key: "drawerRef", ref: w, modelValue: d.value, "onUpdate:modelValue": e[1] || (e[1] = (m) => d.value = m), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: f(() => [c(ce, { ref_key: "matSpecRef", ref: u, modelValue: n(t).list, "onUpdate:modelValue": e[0] || (e[0] = (m) => n(t).list = m), "basic-class": n(I), "max-height": n(z), "row-init-fn": L, "table-width": 430, visible: d.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), c(n(ve), { visible: _.value, "onUpdate:visible": e[2] || (e[2] = (m) => _.value = m), params: S.value, onUseInventory: D }, null, 8, ["visible", "params"])]);
  };
} }, qe = ae(be, [["__scopeId", "data-v-659839a4"]]);
export {
  qe as default
};
