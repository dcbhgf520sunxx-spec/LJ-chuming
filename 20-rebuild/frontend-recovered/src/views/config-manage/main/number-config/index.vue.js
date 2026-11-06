import { ref as _ } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as f } from "vue";
import { unref as n } from "vue";
import { withModifiers as C } from "vue";
import { Fragment as j } from "vue";
import { createVNode as c } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as b } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as B } from "vue";
import { withDirectives as G } from "vue";
import { toDisplayString as h } from "vue";
import { withKeys as T } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElInputNumber as q } from "element-plus";
import { vLoading as J } from "element-plus";
import { l as O, _ as Q, x as X, eH as k, o as Z, G as A, eI as $, O as V } from "../../../../shared/runtime.js";
import { u as ee } from "../../../../modules/use-table-change-32e98420.js";
function oe() {
  return O({ module: "config", url: "project-config/number", method: "get" });
}
function te(N) {
  return O({ module: "config", url: "project-config/number", method: "post", data: N });
}
const E = { get: oe, save: te };
const ae = { key: 0 }, ne = { key: 0 }, le = { __name: "index", setup(N) {
  const R = /* @__PURE__ */ new Map([["code", "sourceCode"], ["number", "sourceNumber"]]), o = _({}), d = _(false), g = _(false), w = _(), { CRUD: m, crud: s } = X({ title: "编号配置", formStore: false, sort: ["id.desc"], permission: { ...k }, crudApi: { ...E } }, w), { maxHeight: S } = Z({ paginate: true }), { changedCellMask: M } = ee({ fieldMap: R });
  m.HOOK.handleRefresh = (t, { data: { content: e = [] } }) => {
    e.forEach((l) => {
      l.sourceCode = l.code, l.sourceNumber = l.number, l.isEdit = false;
    });
  };
  function U(t) {
    A(k.edit) && (o.value.type || (o.value = t, t.isEdit = true));
  }
  const r = V(async function(t) {
    if (!d.value && !t.isEdit && o.value.type) {
      if (!o.value.code) {
        s.notify("请填写代号", m.NOTIFICATION_TYPE.WARNING);
        return;
      }
      try {
        (o.value.code !== o.value.sourceCode || o.value.number !== o.value.sourceNumber) && (await E.save([{ ...o.value }]), s.notify("保存成功", m.NOTIFICATION_TYPE.SUCCESS), o.value.sourceCode = o.value.code, o.value.sourceNumber = o.value.number);
      } catch (e) {
        o.value.code = o.value.sourceCode, o.value.number = o.value.sourceNumber, console.log("保存编号配置", e);
      } finally {
        o.value.isEdit = false, o.value = {};
      }
    }
  }, 200, false);
  function P() {
    const t = [];
    return s.data.forEach((e) => {
      (e.code !== e.sourceCode || e.number !== e.sourceNumber) && t.push({ type: e.type, code: e.code, number: e.number });
    }), t;
  }
  const D = V(async function(t) {
    const e = P();
    if (!e.length) {
      x();
      return;
    }
    if (!s.data.every((l) => !!l.code)) {
      s.notify("请填写代号", m.NOTIFICATION_TYPE.WARNING);
      return;
    }
    try {
      g.value = true, await E.save(e), s.notify("保存成功", m.NOTIFICATION_TYPE.SUCCESS), d.value = false, s.refresh();
    } catch (l) {
      console.log("保存编号配置", l);
    } finally {
      g.value = false;
    }
  }, 200, false);
  function K() {
    d.value = true, s.data.forEach((t) => {
      t.isEdit = true;
    });
  }
  function x() {
    d.value = false, o.value = {}, s.data.forEach((t) => {
      t.code = t.sourceCode, t.number = t.sourceNumber, t.isEdit = false;
    });
  }
  return (t, e) => {
    const l = I("common-button"), p = L, z = W, F = q, H = I("common-table"), Y = J;
    return u(), f("div", { class: "app-container", onClick: e[1] || (e[1] = C((...a) => n(r) && n(r)(...a), ["self", "stop"])) }, [n(A)(n(k).edit) ? (u(), f("div", { key: 0, class: "head-container", onClick: e[0] || (e[0] = C((...a) => n(r) && n(r)(...a), ["stop"])) }, [d.value ? (u(), f(j, { key: 0 }, [c(l, { type: "primary", size: "default", onClick: C(x, ["stop"]) }, { default: i(() => e[2] || (e[2] = [b("取消")])), _: 1, __: [2] }), c(l, { size: "default", type: "success", loading: g.value, onClick: n(D) }, { default: i(() => e[3] || (e[3] = [b("保存")])), _: 1, __: [3] }, 8, ["loading", "onClick"])], 64)) : (u(), y(l, { key: 1, type: "primary", size: "default", onClick: K }, { default: i(() => e[4] || (e[4] = [b("编辑")])), _: 1, __: [4] }))])) : B("", true), G((u(), y(H, { ref_key: "tableRef", ref: w, data: n(s).data, "show-empty-symbol": false, "return-source-data": "", "max-height": n(S), style: { width: "100%" }, "cell-class-name": n(M), onRowClick: n(r), onRowDblclick: U, class: "table-input-border-none" }, { default: i(() => [c(p, { label: "序号", type: "index", align: "center", width: "60" }), c(p, { key: "type", prop: "type", label: "名称", align: "center" }, { default: i(({ row: a }) => [b(h(n($).VL[a.type]), 1)]), _: 1 }), c(p, { key: "code", prop: "code", "show-overflow-tooltip": true, label: "代号", align: "center" }, { default: i(({ row: a }) => [a.isEdit ? (u(), y(z, { key: 1, modelValue: a.code, "onUpdate:modelValue": (v) => a.code = v, modelModifiers: { trim: true }, clearable: "", type: "text", size: "default", maxlength: "10", placeholder: "请填写代号", style: { width: "100%" }, onKeydown: T(n(r), ["enter"]) }, null, 8, ["modelValue", "onUpdate:modelValue", "onKeydown"])) : (u(), f("div", ae, h(a.code), 1))]), _: 1 }), c(p, { key: "number", prop: "number", "show-overflow-tooltip": true, label: "流水号", align: "center" }, { default: i(({ row: a }) => [a.isEdit ? (u(), y(F, { key: 1, modelValue: a.number, "onUpdate:modelValue": (v) => a.number = v, step: 1, min: 1, max: 10, size: "default", style: { width: "100%" }, onKeydown: T(n(r), ["enter"]) }, null, 8, ["modelValue", "onUpdate:modelValue", "onKeydown"])) : (u(), f("div", ne, h(a.number), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name", "onRowClick"])), [[Y, n(s).loading]])]);
  };
} }, ie = Q(le, [["__scopeId", "data-v-0b9f114c"]]);
export {
  ie as default
};
