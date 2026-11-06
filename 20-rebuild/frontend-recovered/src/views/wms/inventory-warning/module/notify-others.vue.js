import { inject as D } from "vue";
import { ref as h } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as v } from "vue";
import { createBlock as b } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as I } from "vue";
import { createTextVNode as O } from "vue";
import { unref as l } from "vue";
import { createVNode as s } from "vue";
import { isRef as S } from "vue";
import { ElNotification as q } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { vLoading as M } from "element-plus";
import { l as n, dS as P, u as G, cy as K, G as V, i as W, a9 as $ } from "../../../../shared/runtime.js";
import { _ as F } from "../../../../modules/dept-cascader-6af417b9.js";
function H(e) {
  return n({ module: "wms", url: "material/inventory-warning", method: "get", params: e });
}
function J(e) {
  return n({ module: "wms", url: "material/inventory-warning/batch", method: "post", data: e });
}
function le(e) {
  return n({ module: "wms", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "material/inventory-warning/minimumInventory", method: "put", data: e });
}
function ae(e) {
  return n({ module: "wms", headers: { "Content-Type": "application/x-www-form-urlencoded" }, url: "material/inventory-warning/enabled", cancelKey: false, method: "put", data: e });
}
function Q(e) {
  return n({ module: "wms", url: "material/inventory-warning", method: "delete", data: e });
}
function X() {
  return n({ module: "wms", url: "material/inventory-warning/notify-config", method: "get" });
}
function Y(e) {
  return n({ module: "wms", url: "material/inventory-warning/notify-config", method: "put", data: e });
}
const ne = { get: H, batchAdd: J, del: Q }, Z = { __name: "notify-others", props: { modelValue: { type: Boolean, require: true } }, emits: ["success", "update:modelValue"], setup(e, { emit: k }) {
  const C = k, N = e, c = D("permission"), i = h({ list: [] }), m = h(false), p = h(false), { loaded: x, workshops: _ } = P(T), { visible: f, handleClose: g } = G({ emit: C, props: N });
  async function T() {
    try {
      if (i.value.list = [], W(_.value)) {
        p.value = true;
        const t = await j();
        _.value.forEach((o) => {
          const d = t[o.id] || {};
          i.value.list.push({ workshopId: o.id, workshopName: o.name, userIds: d.userIds || [], deptIds: d.deptIds || [] });
        });
      }
    } catch (t) {
      console.log("数据转换", t);
    } finally {
      p.value = false;
    }
  }
  async function j() {
    let t = {};
    try {
      const { content: o } = await X();
      t = $(o, "workshopId");
    } catch (o) {
      console.log("配置信息", o);
    }
    return t;
  }
  async function U() {
    m.value = true;
    try {
      await Y(i.value.list), q({ title: "修改成功", type: "success" }), g();
    } catch (t) {
      console.log("保存预警通知配置", t);
    } finally {
      m.value = false;
    }
  }
  return (t, o) => {
    const d = y("common-button"), u = A, B = y("common-table"), E = y("common-drawer"), R = L("permission"), z = M;
    return v(), b(E, { ref: "drawerRef", modelValue: l(f), "onUpdate:modelValue": o[0] || (o[0] = (a) => S(f) ? f.value = a : null), direction: "rtl", size: 1200, title: "预警通知人", "wrapper-closable": false, "before-close": l(g) }, { titleRight: r(() => [I((v(), b(d, { loading: m.value, type: "primary", size: "default", onClick: U }, { default: r(() => o[1] || (o[1] = [O(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading"])), [[R, l(c).edit]])]), content: r(() => [I((v(), b(B, { data: i.value.list, "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" }, "row-key": "workshopId" }, { default: r(() => [s(u, { label: "序号", type: "index", align: "center", width: "60" }), s(u, { prop: "workshopName", label: "车间名称", "show-overflow-tooltip": true, width: "150" }), s(u, { prop: "createTime", label: "通知人", "show-overflow-tooltip": true, "min-width": "180" }, { default: r((a) => [s(K, { modelValue: a.row.userIds, "onUpdate:modelValue": (w) => a.row.userIds = w, filterable: "", "collapse-tags": false, disabled: !l(V)(l(c).edit), multiple: "", clearable: "", "show-all-levels": "", style: { width: "100%" }, placeholder: "选择通知人" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(u, { prop: "createTime", label: "通知部门", "show-overflow-tooltip": true, "min-width": "180" }, { default: r((a) => [s(F, { modelValue: a.row.deptIds, "onUpdate:modelValue": (w) => a.row.deptIds = w, filterable: "", "collapse-tags": false, disabled: !l(V)(l(c).edit), multiple: "", clearable: "", "show-all-levels": "", style: { width: "100%" }, placeholder: "选择通知部门" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data"])), [[z, !l(x) || p.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, re = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  le as a,
  ne as c,
  ae as e,
  re as n
};
