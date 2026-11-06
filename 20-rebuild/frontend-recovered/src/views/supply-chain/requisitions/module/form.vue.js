import { _ as R, j_ as a, wp as m, v0 as y, ao as g, i as L, wc as T, cO as S, jl as w, bb as z } from "../../../../shared/runtime.js";
import F from "./application/steel/index.vue.js";
import P from "./application/auxiliary-material/index.vue.js";
import j from "./application/manufactured/index.vue.js";
import D from "./application/other/index.vue.js";
import { computed as p } from "vue";
import { watch as I } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as U } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as C } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as V } from "vue";
import { resolveDynamicComponent as q } from "vue";
import "./application/components/common-wrapper.vue.js";
import "./application/components/common-footer.vue.js";
import "./application/components/confirm-dialog.vue.js";
import "../../../../modules/use-approval-cfg-0a67817c.js";
import "./application/steel/module/steel-plate-table.vue.js";
import "./application/steel/module/section-steel-table.vue.js";
import "./application/steel/module/steel-coil-table.vue.js";
import "./application/components/inventory-drawer.vue.js";
import "../../../../modules/aux-material-a427f83d.js";
import "./application/auxiliary-material/module/aux-mat-table.vue.js";
import "./application/manufactured/module/enclosure-table.vue.js";
import "./application/manufactured/module/structure-table.vue.js";
import "../../../../modules/other-e93f8d3e.js";
const B = { class: "requisitions-application-select" }, x = { __name: "form", setup(k) {
  const A = { materialType: a.STEEL.V, type: m.PROJECT.V, finishedProductType: y.STRUC_MANUFACTURED.V, projectId: void 0, arrivalTime: "", serialNumber: "", steelPlateList: [], sectionSteelList: [], steelCoilList: [], remark: "", list: [] }, { CRUD: f, crud: r, form: o } = g(A), N = p(() => r.status.cu > f.STATUS.NORMAL), v = p(() => r.status.edit > 0), u = p(() => !!(o.materialType & a.MANUFACTURED.V));
  I(() => o.type, (s) => {
    s & m.PUBLIC.V && (o.projectId = void 0);
  }), I(() => o.materialType, (s, e) => {
    s && e && s !== e && (o.list = []);
  }), I(() => u, (s) => {
    u.value && (o.type = m.PROJECT.V);
  });
  const b = p(() => {
    switch (o.materialType) {
      case a.STEEL.V:
        return F;
      case a.MATERIAL.V:
        return P;
      case a.MANUFACTURED.V:
        return j;
      case a.OTHER.V:
        return D;
      default:
        return;
    }
  });
  f.HOOK.beforeEditDetailLoaded = async (s, e) => {
    var l;
    L(e.project) && (e.projectId = (l = e.project) == null ? void 0 : l.id), u.value ? e.list = e.detailList.map((i) => i) : (e.originInventoryInfo || (e.originInventoryInfo = {}), e.list = e.detailList.map((i) => {
      var n, _;
      return i.materialInventoryId ? (i.requisitionMode = T.USE_INVENTORY.V, e.originInventoryInfo[i.materialInventoryId] ? (e.originInventoryInfo[i.materialInventoryId].frozenQuantity -= i.quantity, e.originInventoryInfo[i.materialInventoryId].frozenQuantity < 0 && (e.originInventoryInfo[i.materialInventoryId].frozenQuantity = 0)) : e.originInventoryInfo[i.materialInventoryId] = { quantity: (n = i.materialFreezeNum) == null ? void 0 : n.quantity, frozenQuantity: ((_ = i.materialFreezeNum) == null ? void 0 : _.frozenQuantity) - i.quantity }) : i.requisitionMode = T.PURCHASE.V, i;
    }), await S(e.list), e.list = await w(e.list, { toSmallest: false, toNum: true }));
  };
  function M() {
    r.cancelCU(), r.refresh();
  }
  return (s, e) => {
    const l = E("common-radio-button"), i = E("common-drawer");
    return d(), c(i, { ref: "drawerRef", "before-close": t(r).cancelCU, "content-loading": t(r).editDetailLoading, "show-close": true, title: t(r).status.title, visible: N.value, "custom-class": "requisitions-application-record-form", size: "100%" }, { titleRight: U(() => e[4] || (e[4] = [])), content: U(() => [O("div", B, [C(l, { modelValue: t(o).materialType, "onUpdate:modelValue": e[0] || (e[0] = (n) => t(o).materialType = n), disabledVal: [t(a).MANUFACTURED.V], options: t(a).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"]), u.value ? (d(), c(l, { key: 0, modelValue: t(o).finishedProductType, "onUpdate:modelValue": e[1] || (e[1] = (n) => t(o).finishedProductType = n), disabledVal: [t(y).ENCL_MANUFACTURED.V], options: t(y).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"])) : V("", true), u.value ? V("", true) : (d(), c(l, { key: 1, modelValue: t(o).type, "onUpdate:modelValue": e[2] || (e[2] = (n) => t(o).type = n), options: t(m).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])), C(z, { modelValue: t(o).projectId, "onUpdate:modelValue": e[3] || (e[3] = (n) => t(o).projectId = n), disabled: t(o).type === t(m).PUBLIC.V, clearable: "", style: { width: "400px" } }, null, 8, ["modelValue", "disabled"])]), t(r).status.cu > t(f).STATUS.NORMAL ? (d(), c(q(b.value), { key: 0, detail: t(o), isEdit: v.value, onSuccess: M }, null, 40, ["detail", "isEdit"])) : V("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, le = R(x, [["__scopeId", "data-v-016ea52d"]]);
export {
  le as default
};
