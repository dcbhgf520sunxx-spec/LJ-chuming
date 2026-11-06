// New compatibility helpers; provenance and behavioral comparisons in tools/verify-recovery.mjs.
export const commonjsGlobal = globalThis;
const externalValue = {};
export const browserExternal = Object.defineProperties({}, {
  __esModule: { value: true },
  default: { enumerable: true, get() { return externalValue; } }
});
export function getDefaultExportFromCjs(value) {
  return value && value.__esModule && Object.prototype.hasOwnProperty.call(value, 'default') ? value.default : value;
}
export function commonjsRequire(name) {
  throw new Error('Could not dynamically require "' + name + '". Please configure the dynamicRequireTargets or/and ignoreDynamicRequires option of @rollup/plugin-commonjs appropriately for this require call to work.');
}
